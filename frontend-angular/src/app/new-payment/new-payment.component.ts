import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {PaymentType, Ville} from "../model/students.model";
import {StudentsService} from "../services/students.service";
import {VilleService} from "../services/ville.service";

@Component({
  selector: 'app-new-payment',
  templateUrl: './new-payment.component.html',
  styleUrl: './new-payment.component.css'
})
export class NewPaymentComponent implements  OnInit{

  paymentFormGroup! : FormGroup;
  studentCode! :string;
  paymentTypes :string[]=[];
  pdfFileUrl! : string;

  villes: Ville[] = [];
  showProgress : boolean = false;

  selectedVille : Ville | undefined;
  constructor(private  fb : FormBuilder,private activatedRoute : ActivatedRoute,private studentsService : StudentsService,private villeService : VilleService) {
  }
  ngOnInit(): void {
    for(let elt in PaymentType){
      let value : string = PaymentType[elt];
      if (typeof value === 'string'){
        this.paymentTypes.push(value);
      }

      this.villeService.getAllVille().subscribe(data =>{
        this.villes = data;
      })

    }
    this.studentCode = this.activatedRoute.snapshot.params['studentCode'];
    this.paymentFormGroup = this.fb.group({
      date : this.fb.control(''),
      amount : this.fb.control(''),
      type : this.fb.control(''),
      ville : this.fb.control(''),
      studentCode : this.fb.control(this.studentCode),
      fileSource :this.fb.control(''),
      fileName : this.fb.control('')

    });
  }

  selectFile(event:any) {
    if (event.target.files.length>0){
      let file = event.target.files[0];
      this.paymentFormGroup.patchValue({
        fileSource : file,
        fileName : file.name
      });
      this.pdfFileUrl = window.URL.createObjectURL(file);
    }

  }

  savePayment() {
    this.showProgress = true;
    let date = new Date(this.paymentFormGroup.value.date);
    let formatedDate : string = date.getDate()+"/"+(date.getMonth()+1)+"/"+date.getFullYear();
    let formData = new FormData();
    formData.set('date',formatedDate);
    formData.set('amount',this.paymentFormGroup.value.amount);
    formData.set('type',this.paymentFormGroup.value.type);
    formData.set('studentCode',this.paymentFormGroup.value.studentCode);
    formData.set('file',this.paymentFormGroup.value.fileSource);
    formData.set('ville',this.paymentFormGroup.value.ville);
    this.studentsService.savePayment(formData).subscribe({
      next : value => {
        console.log("value ",value);
        this.showProgress = false;
        alert('Payment effectue avec succes !')
      },
      error:err => {
        console.log(err);
      }
    })
  }

  afterLoadComplete(event: any) {
    console.log(event);
  }
}

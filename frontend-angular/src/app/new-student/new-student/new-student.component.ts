import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {StudentsService} from "../../services/students.service";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-new-student',
  templateUrl: './new-student.component.html',
  styleUrl: './new-student.component.css'
})
export class NewStudentComponent implements OnInit{


  //studentFormGroup! : FormGroup;

  public studentFormGroup = new FormGroup({
    code : new FormControl('',[Validators.required,Validators.minLength(3)]),
    firstName : new FormControl('',[Validators.required,Validators.minLength(3)]),
    lastName : new FormControl('',[Validators.required,Validators.minLength(3)]),
    programId : new FormControl('',[Validators.required,Validators.minLength(3)]),
  });

  showProgress : boolean = false;

  constructor(private  fb : FormBuilder,private activatedRoute : ActivatedRoute,private studentsService : StudentsService,private toastr: ToastrService) {
  }

  ngOnInit(): void {
    /*this.studentFormGroup = this.fb.group({
      code : this.fb.control(''),
      firstName : this.fb.control(''),
      lastName : this.fb.control(''),
      programId :this.fb.control('')
    });*/
    }

  saveStudent(){
    //let formData = new FormData();
    const formData = this.studentFormGroup.value;
    /*formData.set('code',this.studentFormGroup.value.code);
    formData.set('firstName',this.studentFormGroup.value.firstName);
    formData.set('lastName',this.studentFormGroup.value.lastName);
    formData.set('programId',this.studentFormGroup.value.programId);*/
    console.log("formData",formData);
    this.showProgress = true;
    this.studentsService.saveStudent(formData).subscribe({
      next : value => {
        console.log("value ",value);
        this.showProgress = false;
        this.toastr.success('Student enregistré avec succès !', 'Succès');
        //alert('Student enregistré avec succes !')
      },
      error:err => {
        this.showProgress = false;
        this.toastr.error('Une erreur est survenue lors de l\'enregistrement.', 'Erreur');
        console.log(err);
      }
    })
  }
}

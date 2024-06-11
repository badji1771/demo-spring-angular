import {Component, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {StudentsService} from "../services/students.service";
import {Payment} from "../model/students.model";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrl: './student-details.component.css'
})
export class StudentDetailsComponent implements OnInit{

  studentCode!:string;
  studentPayment! :Array<Payment>;
  paymentDataSource! : MatTableDataSource<Payment>;
  public displayedColumns =['id','amount','date','type','status','firstName'];
  @ViewChild(MatPaginator) paginator! : MatPaginator;
  @ViewChild(MatSort) sort! : MatSort;
  constructor(private activateRoute :ActivatedRoute,private studentsService : StudentsService,private router : Router) {
  }
  ngOnInit(): void {
    this.studentCode =this.activateRoute.snapshot.params['code'];
    this.studentsService.getStudentPayments(this.studentCode).subscribe({
      next : value => {
        this.studentPayment = value;
        this.paymentDataSource = new MatTableDataSource<Payment>(this.studentPayment);
        this.paymentDataSource.paginator = this.paginator;
        this.paymentDataSource.sort = this.sort;
      },
      error : err => {
        console.log(err);
      }
    })
  }

  newPayment() {
    this.router.navigateByUrl(`/admin/new-payment/${this.studentCode}`)
  }
}

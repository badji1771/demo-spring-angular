import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Payment} from "../model/students.model";

@Injectable({
  providedIn: 'root'
})
export class StudentsService {

  constructor(private http : HttpClient) { }

  public getAllPayments():Observable<Array<Payment>>{
    return this.http.get<Array<Payment>>(`${environment.backendHost}/payments`)
  }
}
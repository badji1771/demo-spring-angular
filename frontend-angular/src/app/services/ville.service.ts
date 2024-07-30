import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Payment, Ville} from "../model/students.model";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class VilleService {

  constructor(private http : HttpClient) { }

  public getAllVille():Observable<Array<Ville>>{
    return this.http.get<Array<Ville>>(`${environment.backendHost}/api/villes`)
  }
}

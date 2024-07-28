import { Injectable } from '@angular/core';
import {Router} from "@angular/router";
import {Payment, User} from "../model/students.model";
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {catchError, map, Observable, of} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  public users:any ={
    admin :{password:'1234',roles:['STUDENT','ADMIN']},
    user1 :{password:'1234',roles:['STUDENT']},
  }

  public username : any;
  public isAuthenticated : boolean = false;
  public roles : string[] =[];
  public roleUserConnected : any;
  constructor(private http : HttpClient,private router : Router) { }

  islogin = false;

  login(username: string): Observable<User | null> {
    return this.http.get<User>(`${environment.backendHost}/api/users/auth/${username}`).pipe(
      map(user => {
        if (user) {
          this.isAuthenticated = true;
          this.roleUserConnected=user.role;
          return user;
        } else {
          this.isAuthenticated = false;
          return null;
        }
      }),
      catchError(error => {
        this.isAuthenticated = false;
        console.error('Login error', error);
        return of(null); // Return a null observable in case of error
      })
    );
  }
  /*public login(username : string, password : string):boolean{
  if(this.users[username] && this.users[username]['password']==password){
    this.username = username;
    this.isAuthenticated = true;
    this.roles=this.users[username]['roles'];
    return true;
  }else{
    return false;
  }
  }*/

  logout() {
    this.isAuthenticated=false;
    this.roles=[];
    this.username =undefined;
    this.router.navigateByUrl("/login")
  }
}

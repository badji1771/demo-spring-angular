import { Injectable } from '@angular/core';
import {Router} from "@angular/router";
import {Payment, Role, User} from "../model/students.model";
import {environment} from "../../environments/environment";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {catchError, map, Observable, of} from "rxjs";
import {jwtDecode} from "jwt-decode";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  public userRoles :any;
  /*public users:any ={
    admin :{password:'1234',roles:['STUDENT','ADMIN']},
    user1 :{password:'1234',roles:['STUDENT']},
  }*/

  public username : any;
  public isAuthenticated : boolean = false;
  public roles : string[] =[];
  accessToken!:string;


  constructor(private http : HttpClient,private router : Router) { }


  public login(username : string,password : string){
    let options = {
      headers : new HttpHeaders().set("Content-Type","application/x-www-form-urlencoded")
    }
    let params = new HttpParams().set("username",username).set("password",password).set("withRefreshToken",false).set("grantType","password");
    return this.http.post(`${environment.backendHost}/token`,params,options)
  }

  loadProfile(data: any){
    console.log("data ",data);
    this.isAuthenticated = true;
    this.accessToken = data['accessToken'];
    let decodeJwt:any = jwtDecode(this.accessToken);
    console.log("decodeJwt ",decodeJwt);
    this.username = decodeJwt.sub;
    this.roles = decodeJwt.scope;
    //window.localStorage.setItem("jwt-token",this.accessToken);
  }

  /*login(username :string ) {
    this.isAuthenticated = true;
    return this.http.get<User>(`${environment.backendHost}/api/users/auth/${username}`)
  }*/

  /*allRolesByUser(username :string ) {
    this.isAuthenticated = true;
    return this.http.get<Array<Role>>(`${environment.backendHost}/api/userole/role/${username}`)
  }*/

  /*login(username: string): Observable<User | null> {
    return this.http.get<User>(`${environment.backendHost}/api/users/auth/${username}`).pipe(
      map(user => {
        if (user) {
          this.isAuthenticated = true;
          this.rolesByUser(user.username);
          this.username =user.username;
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
  }*/



  /*public rolesByUser(username : string){
    this.allRolesByUser(username).subscribe(
      datas =>{
        this.rolesForUser = datas;
        console.log("this.rolesForUser",this.rolesForUser);
        if (this.rolesForUser){
          for (var element of this.rolesForUser){
            this.roles.push(element.code.toString());
          }
        }

      }
    )
  }*/
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
    this.accessToken="undefined";
    window.localStorage.removeItem('accessToken');
    this.router.navigateByUrl("/login")
  }

  loadJwtTokenFromLocalStorage() {
    let token = window.localStorage.getItem("jwt-token");
    if(token){
      this.loadProfile({'accessToken':token});
      this.router.navigateByUrl("/admin")
    }
  }
}

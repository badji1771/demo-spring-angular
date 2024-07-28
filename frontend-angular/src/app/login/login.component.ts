import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {AuthService} from "../services/auth.service";
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit{

  public loginForm! : FormGroup;
  constructor(private fb:FormBuilder,private authService : AuthService,public toastr: ToastrService,private router: Router) {
  }
  user: any = {};

  public isAuthenticated : boolean = false;
  ngOnInit(): void {
    this.loginForm = this.fb.group({
      username : this.fb.control(''),
      password : this.fb.control(''),
    });
  }

  /*login() {
    let username = this.loginForm.value.username;
    let password = this.loginForm.value.password;
    let auth:boolean=this.authService.login(username,password);
    if(auth==true){
      this.router.navigateByUrl("/admin")
    }
  }*/
  login() {
    let username = this.loginForm.value.username;
    let password = this.loginForm.value.password;
    this.authService.login(username).subscribe(
      res => {
        console.log("user connected ",res);
        this.user = res;
        if (this.user)
        {
          console.log("this.user  ",this.user);
          if (this.user.password == password) {
            localStorage.setItem("name", this.user.nom);
            localStorage.setItem("idUser", this.user.id);
            localStorage.setItem("code", this.user.matricule);
            localStorage.setItem("role", this.user.role);
            localStorage.setItem("matricule", this.user.matricule);
            this.authService.islogin = true;
           // this.isAuthenticated = true;
            if (this.user.role == "ADMIN") {
              console.log("this.user.role  ",this.user.role);
              this.router.navigateByUrl("/admin")
            }
            else {
              this.router.navigateByUrl("/admin")

            }
          }
          else {
            this.toastr.warning('Mot de Passe  Incorrecte ')
          }
        }
        else
        {
          this.toastr.warning('Login Incorrecte ')
        }



      }
    );
  }



}

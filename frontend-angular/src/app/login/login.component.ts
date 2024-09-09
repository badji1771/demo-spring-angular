import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {AuthService} from "../services/auth.service";
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit{

  public loginForm = new FormGroup({
  username : new FormControl('',[Validators.required,Validators.minLength(3)]),
    password : new FormControl('',[Validators.required,Validators.minLength(3)]),
});

  constructor(private fb:FormBuilder,private authService : AuthService,public toastr: ToastrService,private router: Router) {
  }
  user: any = {};

  public isAuthenticated : boolean = false;
  ngOnInit(): void {
   /* this.loginForm = this.fb.group({
      username : this.fb.control('',[Validators.required,Validators.minLength(3)]),
      password : this.fb.control(''),
    });*/
  }
isInvalidAndToucheOrDrity(formControl : FormControl){
    return formControl.invalid && (formControl.touched || formControl.dirty);
}

  /*login() {
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
            if (this.user.username == "admin") {
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
  }*/

  login(){
    this.loginForm.markAllAsTouched();
    if(this.loginForm.invalid){
      return;
    }
    let username = this.loginForm.value.username;
    let password = this.loginForm.value.password;
    this.authService.login(<string>username,<string>password).subscribe({
      next:data =>{
        this.authService.loadProfile(data);
        this.router.navigateByUrl("/admin")
      },
      error:err =>{
        console.log(err);
      }
    })
  }


}

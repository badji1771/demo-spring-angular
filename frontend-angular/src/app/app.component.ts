import {Component, OnInit} from '@angular/core';
import {AuthService} from "./services/auth.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{

  public isAuthenticated = false;
  title = 'frontend-angular-app';

  public logout(): void {
    // todo
  }

  constructor(private authService : AuthService) {
  }
  ngOnInit(): void {
   // this.authService.loadJwtTokenFromLocalStorage();
  }
}

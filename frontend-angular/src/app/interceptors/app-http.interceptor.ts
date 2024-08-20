import {
  HttpEvent,
  HttpHandler,
  HttpHeaders,
  HttpInterceptor,
  HttpInterceptorFn,
  HttpRequest
} from '@angular/common/http';
import {AuthService} from "../services/auth.service";
import {inject, Injectable} from "@angular/core";
import {catchError, Observable, throwError} from "rxjs";
import {error} from "@angular/compiler-cli/src/transformers/util";

export const appHttpInterceptor: HttpInterceptorFn = (req, next) => {

  const auth = inject(AuthService);
  const token = auth.accessToken

  if (!token) {
    return next(req)
  }

  const headers = new HttpHeaders({
    Authorization: `Bearer ${token}`
  })

  const newReq = req.clone({
    headers
  })
 /* const newReq = req.clone({
    headers: req.headers.append('Authorization','Bearer '+ token)
  });*/

  return next(newReq)/*.pipe(
    catchError(error=>{
      if (error.status==401){
        auth.logout();
      }
      return throwError(error.message);
    })
  )*/
};


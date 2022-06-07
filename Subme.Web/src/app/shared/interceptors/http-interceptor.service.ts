import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { catchError, take } from 'rxjs/operators';
import { ConfirmDialogConfig } from '../components/confirm-dialog/classes/confirm-dialog-config';
import { ConfirmDialogService } from '../components/confirm-dialog/services/confirm-dialog.service';
import { AuthService } from '../services/auth.service';

@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorService implements HttpInterceptor {

  constructor(
    private authService: AuthService,
    private confirmDialogService: ConfirmDialogService,
    private router: Router
  ) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token = this.authService.getToken();
    if (token) {
      req = this.setToken(req, token);
    }
    return next.handle(req)
      .pipe(
        catchError((error: HttpEvent<any>) => {
          if (error instanceof HttpErrorResponse) {
            this.error401Handler(error);
          }
          return throwError(error);
        })
      );
  }

  error401Handler(error: HttpErrorResponse): void {
    if (error.status !== 401) {
      return;
    }
    const config = {
      title: "Sessão expirada",
      message: "Sua sessão expirou! Por gentileza, entre novamente no sistema.",
    } as ConfirmDialogConfig;
    this.confirmDialogService.open(config);
    this.confirmDialogService.closed
      .pipe(take(1))
      .subscribe(() => {
        this.authService.clearToken();
        this.router.navigate(['login']);
      });
  }

  setToken(req: HttpRequest<any>, token: string): HttpRequest<any> {
    return req.clone({ headers: req.headers.set('Authorization', `Bearer ${token}`) });
  }
}

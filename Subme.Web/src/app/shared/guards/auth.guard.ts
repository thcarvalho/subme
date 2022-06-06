import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { take } from 'rxjs/operators';
import { ConfirmDialogService } from '../components/confirm-dialog/services/confirm-dialog.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(
    public router: Router,
    private confirmDialogService: ConfirmDialogService
  ) { }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    const hasToken = !!window.sessionStorage.getItem("@token");
    if (!hasToken) {
      this.showMessageAndLogout();
      this.router.navigate(['login']);
    }
    return hasToken;
  }

  showMessageAndLogout(): void {
    this.confirmDialogService.open({
      title: 'Ops...',
      message: 'Você precisa estar logado para acessar essa área',
    });
    this.confirmDialogService.closed
      .pipe(take(1))
      .subscribe();
  }
}

import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomersComponent } from './pages/customers/customers.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { PlansComponent } from './pages/plans/plans.component';
import { SubscriptionsComponent } from './pages/subscriptions/subscriptions.component';
import { MainLayoutComponent } from './shared/components/main-layout/main-layout.component';
import { AuthGuard } from './shared/guards/auth.guard';
import { HttpInterceptorService } from './shared/interceptors/http-interceptor.service';

const routes: Routes = [
  {
    path: 'dashboard',
    component: MainLayoutComponent,
    canActivate: [AuthGuard],
    children: [
      { path: 'home', component: HomeComponent },
      { path: 'customers', component: CustomersComponent },
      { path: 'plans', component: PlansComponent },
      { path: 'subscriptions', component: SubscriptionsComponent },
    ],
  },
  { path: 'login', component: LoginComponent },
  { path: '**', redirectTo: 'dashboard/home' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: HttpInterceptorService, multi: true },
  ]
})
export class AppRoutingModule {}

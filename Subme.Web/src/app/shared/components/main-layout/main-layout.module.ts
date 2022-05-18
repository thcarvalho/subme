import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MainLayoutComponent } from './main-layout.component';
import { SidenavModule } from '../sidenav/sidenav.module';
import { RouterModule } from '@angular/router';
import { FlexLayoutModule } from '@angular/flex-layout';

@NgModule({
  declarations: [
    MainLayoutComponent
  ],
  imports: [
    CommonModule,
    SidenavModule,
    RouterModule,
    FlexLayoutModule
  ],
  exports: [
    MainLayoutComponent
  ],
})
export class MainLayoutModule { }

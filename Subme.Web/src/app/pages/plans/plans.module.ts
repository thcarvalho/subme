import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PlansComponent } from './plans.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { TableModule } from 'src/app/shared/components/table/table.module';



@NgModule({
  declarations: [
    PlansComponent
  ],
  imports: [
    CommonModule,
    TableModule,
    FlexLayoutModule,
    MatButtonModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule
  ]
})
export class PlansModule { }

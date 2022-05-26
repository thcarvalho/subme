import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomersComponent } from './customers.component';
import { TableModule } from 'src/app/shared/components/table/table.module';
import { FlexLayoutModule } from '@angular/flex-layout';
import { ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { CustomersFormComponent } from './customers-form/customers-form.component';


@NgModule({
  declarations: [
    CustomersComponent,
    CustomersFormComponent,
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
export class CustomersModule { }

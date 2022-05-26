import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SubscriptionsComponent } from './subscriptions.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { TableModule } from 'src/app/shared/components/table/table.module';



@NgModule({
  declarations: [
    SubscriptionsComponent
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
export class SubscriptionsModule { }

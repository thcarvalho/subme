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
import { SubscriptionsFormComponent } from './subscriptions-form/subscriptions-form.component';
import { ModalModule } from 'src/app/shared/components/modal/modal.module';
import { MatDialogModule } from '@angular/material/dialog';
import { ConfirmDialogModule } from 'src/app/shared/components/confirm-dialog/confirm-dialog.module';
import { SearchInputModule } from 'src/app/shared/components/search-input/search-input.module';



@NgModule({
  declarations: [
    SubscriptionsComponent,
    SubscriptionsFormComponent
  ],
  imports: [
    CommonModule,
    TableModule,
    FlexLayoutModule,
    MatButtonModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatDialogModule,
    ModalModule,
    ConfirmDialogModule,
    SearchInputModule
  ]
})
export class SubscriptionsModule { }

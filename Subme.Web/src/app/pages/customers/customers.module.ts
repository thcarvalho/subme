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
import { ModalModule } from 'src/app/shared/components/modal/modal.module';
import { MatDialogModule } from '@angular/material/dialog';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { ConfirmDialogModule } from 'src/app/shared/components/confirm-dialog/confirm-dialog.module';
import { MatIconModule } from '@angular/material/icon';
import { SearchInputModule } from 'src/app/shared/components/search-input/search-input.module';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { NgxMaskModule } from 'ngx-mask';

@NgModule({
  declarations: [CustomersComponent, CustomersFormComponent],
  imports: [
    CommonModule,
    RouterModule,
    HttpClientModule,
    TableModule,
    FlexLayoutModule,
    MatButtonModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatDialogModule,
    MatSnackBarModule,
    ModalModule,
    ConfirmDialogModule,
    MatIconModule,
    SearchInputModule,
    MatProgressSpinnerModule,
    MatProgressBarModule,
    NgxMaskModule.forRoot()
  ],
  exports: [CustomersComponent, CustomersFormComponent],
})
export class CustomersModule {}

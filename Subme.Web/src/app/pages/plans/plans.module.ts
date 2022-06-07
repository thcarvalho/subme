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
import { PlansFormComponent } from './plans-form/plans-form.component';
import { ModalModule } from 'src/app/shared/components/modal/modal.module';
import { MatDialogModule } from '@angular/material/dialog';
import { SearchInputModule } from 'src/app/shared/components/search-input/search-input.module';
import { MatProgressBarModule } from '@angular/material/progress-bar';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';



@NgModule({
  declarations: [
    PlansComponent,
    PlansFormComponent
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
    SearchInputModule,
    MatProgressSpinnerModule,
    MatProgressBarModule
  ]
})
export class PlansModule { }

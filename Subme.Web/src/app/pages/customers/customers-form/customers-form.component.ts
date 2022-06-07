import { HttpClient } from '@angular/common/http';
import { ChangeDetectionStrategy, ChangeDetectorRef, Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CustomerForm } from 'src/app/shared/classes/form/customer.form';
import { RequestParams } from 'src/app/shared/classes/params/request-params';
import { ModalConfig } from 'src/app/shared/components/modal/classes/modal-config';
import { ModalComponent } from 'src/app/shared/components/modal/modal.component';
import { Customer } from 'src/app/shared/entities/customer.entity';
import { Plan } from 'src/app/shared/entities/plan.entity';
import { CustomerService } from 'src/app/shared/services/customer.service';
import { PlanService } from 'src/app/shared/services/plan.service';

@Component({
  selector: 'app-customers-form',
  templateUrl: './customers-form.component.html',
  styleUrls: ['./customers-form.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class CustomersFormComponent implements OnInit {
  form!: FormGroup;
  isEditMode = false;
  plans!: Plan[];
  isLoading = false;

  constructor(
    @Inject(MAT_DIALOG_DATA) public config: ModalConfig,
    private matDialogRef: MatDialogRef<ModalComponent>,
    private formBuilder: FormBuilder,
    private snackBar: MatSnackBar,
    private customerService: CustomerService,
    private planService: PlanService,
    protected http: HttpClient,
    private cdRef: ChangeDetectorRef,
  ) {
    this.form = this.formBuilder.group({
      id: [null],
      name: [null, [Validators.required]],
      email: [null, [Validators.required, Validators.email]],
      cpf: [null, [Validators.required]],
      planId: [null],
      zipcode: [null, [Validators.required]],
      street: [null, [Validators.required]],
      city: [null, [Validators.required]],
      state: [null, [Validators.required]],
      country: [null, [Validators.required]],
      number: [null, [Validators.required]],
    });
    this.isEditMode = !!this.config.data;
  }

  async ngOnInit(): Promise<void> {
    await this.getPlansAsync();
    if (this.isEditMode) {
      const data = this.config.data as Customer;
      const address = data.address
      this.form.patchValue({
        ...data,
        zipcode: address.zipcode,
        street: address.street,
        city: address.city,
        state: address.state,
        country: address.country,
        number: address.number,
      })
    }
  }

  async getPlansAsync(): Promise<void> {
    this.plans = await this.planService.getAllAsync().toPromise();
    this.cdRef.detectChanges();
  }

  async saveCustomerAsync(): Promise<void> {
    try {
      this.isLoading = true;
      if (this.isFormValid()) {
        const value = this.form.value;
        const data = {
          id: value.id,
          customer: {
            companyId: 1,
            name: value.name,
            email: value.email,
            cpf: value.cpf,
            address: {
              city: value.city,
              number: value.number,
              state: value.state,
              country: value.country,
              street: value.street,
              zipcode: value.zipcode,
            },
          },
          plan: {
            id: value.planId
          }
        } as CustomerForm;
        if (this.isEditMode) {
          await this.customerService.updateAsync(data).toPromise();
        } else {
          await this.customerService.createAsync(data).toPromise();
        }
        this.snackBar.open("Novo cliente salvo com sucesso!", undefined, { duration: 3000 })
        this.matDialogRef.close(true);
      }
    } catch (error) {
      console.error(error);
    } finally {
      this.isLoading = false;
    }
  }

  isFormValid(): boolean {
    const valid = this.form.valid;
    if (!valid) {
      this.form.markAllAsTouched();
      this.snackBar.open("Há campos inválidos no formulário!", undefined, { duration: 3000 })
    }
    return valid;
  }
}

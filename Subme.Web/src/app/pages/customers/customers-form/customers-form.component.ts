import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CustomerForm } from 'src/app/shared/classes/form/customer.form';
import { ModalConfig } from 'src/app/shared/components/modal/classes/modal-config';
import { Customer } from 'src/app/shared/entities/customer.entity';
import { CustomerService } from 'src/app/shared/services/customer.service';

@Component({
  selector: 'app-customers-form',
  templateUrl: './customers-form.component.html',
  styleUrls: ['./customers-form.component.scss'],
})
export class CustomersFormComponent implements OnInit {
  form!: FormGroup;
  isEditMode = false;

  constructor(
    @Inject(MAT_DIALOG_DATA) public config: ModalConfig,
    private formBuilder: FormBuilder,
    private snackBar: MatSnackBar,
    private customerService: CustomerService,
    protected http: HttpClient,
  ) {
    this.form = this.formBuilder.group({
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

  ngOnInit(): void {
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

  async saveCustomerAsync(): Promise<void> {
    try {
      if (this.isFormValid()) {
        const value = this.form.value;
        const data = {
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
              zipcode: value.zipcode,
            },
          },
          plan: {
            id: value.planId
          }
        } as CustomerForm;
        await this.customerService.createAsync(data).toPromise();
      }
    } catch (error) {
      console.error(error);
    }
  }

  isFormValid(): boolean {
    const valid = this.form.valid;
    if (!valid) {
      this.form.markAllAsTouched();
      this.snackBar.open("Há campos inválidos no formulário!")
    }
    return valid;
  }
}

import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { SubscriptionForm } from 'src/app/shared/classes/form/subscription.form';
import { RequestParams } from 'src/app/shared/classes/params/request-params';
import { ModalConfig } from 'src/app/shared/components/modal/classes/modal-config';
import { ModalComponent } from 'src/app/shared/components/modal/modal.component';
import { Customer } from 'src/app/shared/entities/customer.entity';
import { Plan } from 'src/app/shared/entities/plan.entity';
import { Subscription } from 'src/app/shared/entities/subscription.entity';
import { CustomerService } from 'src/app/shared/services/customer.service';
import { PlanService } from 'src/app/shared/services/plan.service';
import { SubscriptionService } from 'src/app/shared/services/subscription.service';

@Component({
  selector: 'app-subscriptions-form',
  templateUrl: './subscriptions-form.component.html',
  styleUrls: ['./subscriptions-form.component.scss']
})
export class SubscriptionsFormComponent implements OnInit {
  form!: FormGroup;
  isEditMode = false;
  plans!: Plan[];
  customers!: Customer[];

  constructor(
    @Inject(MAT_DIALOG_DATA) public config: ModalConfig,
    private matDialogRef: MatDialogRef<ModalComponent>,
    private formBuilder: FormBuilder,
    private snackBar: MatSnackBar,
    private subscriptionService: SubscriptionService,
    private planService: PlanService,
    private customerService: CustomerService,
    protected http: HttpClient,
  ) {
    this.form = this.formBuilder.group({
      id: [null],
      customerId: [null, [Validators.required]],
      planId: [null, [Validators.required]],
    });
    this.isEditMode = !!this.config.data;
  }

  async ngOnInit(): Promise<void> {
    await this.getPlansAsync();
    await this.getCustomersAsync();
    if (this.isEditMode) {
      const data = this.config.data as Subscription;
      this.form.patchValue({
        customerId: data.customer.id,
        planId: data.plan.id
      })
    }
  }

  async getPlansAsync(): Promise<void> {
    this.plans = await this.planService.getAllAsync(new RequestParams()).toPromise();
  }

  async getCustomersAsync(): Promise<void> {
    this.customers = await this.customerService.getAllAsync(new RequestParams()).toPromise();
  }

  async saveSubscriptionAsync(): Promise<void> {
    try {
      if (this.isFormValid()) {
        const value = this.form.value;
        const data = {
          ...value,
          customer: {
            id: value.customerId
          },
          plan: {
            id: value.planId
          }
        } as SubscriptionForm;
        if (this.isEditMode) {
          await this.subscriptionService.updateAsync(data).toPromise();
        } else {
          await this.subscriptionService.createAsync(data).toPromise();
        }
        this.snackBar.open("Nova assinatura salva com sucesso!")
        this.matDialogRef.close(true);
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

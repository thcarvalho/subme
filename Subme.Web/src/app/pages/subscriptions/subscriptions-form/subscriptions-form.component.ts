import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { SubscriptionForm } from 'src/app/shared/classes/form/subscription.form';
import { ModalConfig } from 'src/app/shared/components/modal/classes/modal-config';
import { Subscription } from 'src/app/shared/entities/subscription.entity';
import { SubscriptionService } from 'src/app/shared/services/subscription.service';

@Component({
  selector: 'app-subscriptions-form',
  templateUrl: './subscriptions-form.component.html',
  styleUrls: ['./subscriptions-form.component.scss']
})
export class SubscriptionsFormComponent implements OnInit {
  form!: FormGroup;
  isEditMode = false;

  constructor(
    @Inject(MAT_DIALOG_DATA) public config: ModalConfig,
    private formBuilder: FormBuilder,
    private snackBar: MatSnackBar,
    private subscriptionService: SubscriptionService,
    protected http: HttpClient,
  ) {
    this.form = this.formBuilder.group({
      customerId: [null, [Validators.required]],
      planId: [null, [Validators.required]],
    });
    this.isEditMode = !!this.config.data;
  }

  ngOnInit(): void {
    if (this.isEditMode) {
      const data = this.config.data as Subscription;
      this.form.patchValue({
        customerId: data.customer.id,
        planId: data.plan.id
      })
    }
  }

  async saveSubscriptionAsync(): Promise<void> {
    try {
      console.log(this.form.value);

      if (this.isFormValid()) {
        const value = this.form.value;
        const data = {
          customer: {
            id: value.customerId
          },
          plan: {
            id: value.planId
          }
        } as SubscriptionForm;
        await this.subscriptionService.createAsync(data).toPromise();
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

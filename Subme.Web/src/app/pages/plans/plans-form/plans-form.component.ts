import { HttpClient } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ModalConfig } from 'src/app/shared/components/modal/classes/modal-config';
import { Plan } from 'src/app/shared/entities/plan.entity';
import { PlanService } from 'src/app/shared/services/plan.service';

@Component({
  selector: 'app-plans-form',
  templateUrl: './plans-form.component.html',
  styleUrls: ['./plans-form.component.scss']
})
export class PlansFormComponent implements OnInit {
  form!: FormGroup;
  isEditMode = false;

  constructor(
    @Inject(MAT_DIALOG_DATA) public config: ModalConfig,
    private formBuilder: FormBuilder,
    private snackBar: MatSnackBar,
    private planService: PlanService,
    protected http: HttpClient,
  ) {
    this.form = this.formBuilder.group({
      name: [null, [Validators.required]],
      price: [null, [Validators.required]],
      description: [null, [Validators.required]],
    });
    this.isEditMode = !!this.config.data;
  }

  ngOnInit(): void {
    if (this.isEditMode) {
      const data = this.config.data as Plan;
      this.form.patchValue({...data})
    }
  }

  async savePlanAsync(): Promise<void> {
    try {
      if (this.isFormValid()) {
        const data = {
          ...this.form.value,
          isActive: true,
          companyId: 1
        } as Plan;
        await this.planService.createAsync(data).toPromise();
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

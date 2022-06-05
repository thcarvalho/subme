import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Plan } from '../entities/plan.entity';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class PlanService extends ApiService<Plan, Plan> {

  constructor(
    protected http: HttpClient,
  ) {
    super("plans", http)
  }
}

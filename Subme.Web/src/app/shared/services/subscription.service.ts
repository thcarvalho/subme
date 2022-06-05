import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SubscriptionForm } from '../classes/form/subscription.form';
import { Subscription } from '../entities/subscription.entity';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class SubscriptionService extends ApiService<SubscriptionForm, Subscription> {

  constructor(
    protected http: HttpClient,
  ) {
    super("subscriptions", http)
  }
}

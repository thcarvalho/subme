import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subscription } from '../entities/subscription.entity';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class SubscriptionService extends ApiService<Subscription> {

  constructor(
    protected http: HttpClient,
  ) {
    super("subscriptions", http)
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Customer } from '../entities/customer.entity';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class CustomerService extends ApiService<Customer> {

  constructor(
    protected http: HttpClient,
  ) {
    super("customers", http)
  }
}

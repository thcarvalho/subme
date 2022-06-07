import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CustomerForm } from '../classes/form/customer.form';
import { Customer } from '../entities/customer.entity';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class CustomerService extends ApiService<any, Customer> {

  constructor(
    protected http: HttpClient,
  ) {
    super("customers", http)
  }
}

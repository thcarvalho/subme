import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Invoice } from '../entities/invoice.entity';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class InvoiceService extends ApiService<Invoice> {

  constructor(
    protected http: HttpClient,
  ) {
    super("invoices", http)
  }
}

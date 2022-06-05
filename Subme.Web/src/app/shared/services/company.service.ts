import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Company } from '../entities/company.entity';
import { ApiService } from './api.service';

@Injectable({
  providedIn: 'root'
})
export class CompanyService extends ApiService<Company, Company> {

  constructor(
    protected http: HttpClient,
  ) {
    super("companies", http)
  }
}

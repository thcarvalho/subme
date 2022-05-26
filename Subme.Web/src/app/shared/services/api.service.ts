import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export abstract class ApiService<T> {
  env = environment;

  constructor(
    @Inject("route") private route: string,
    protected http: HttpClient,
  ) { }

  getAllAsync(): Observable<T[]> {
    return this.http.get<T[]>(`${this.env.apiUrl}/${this.route}`);
  }

  createAsync(data: T): Observable<T> {
    return this.http.post<T>(`${this.env.apiUrl}/${this.route}/create`, data);
  }
}

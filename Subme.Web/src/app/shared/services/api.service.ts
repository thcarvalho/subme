import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export abstract class ApiService<TData, TOut> {
  env = environment;

  constructor(
    @Inject("route") private route: string,
    protected http: HttpClient,
  ) { }

  getAllAsync(): Observable<TOut[]> {
    return this.http.get<TOut[]>(`${this.env.apiUrl}/${this.route}`);
  }

  createAsync(data: TData): Observable<TOut> {
    const body = JSON.stringify(data);
    return this.http.post<TOut>(`${this.env.apiUrl}/create/${this.route}`, body);
  }
}

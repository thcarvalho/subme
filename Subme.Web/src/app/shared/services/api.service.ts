import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { RequestParams } from '../classes/params/request-params';

@Injectable({
  providedIn: 'root'
})
export abstract class ApiService<TData, TOut> {
  env = environment;

  constructor(
    @Inject("route") private route: string,
    protected http: HttpClient,
  ) { }

  getAllAsync(params: RequestParams): Observable<TOut[]> {
    return this.http.get<TOut[]>(`${this.env.apiUrl}/${this.route}`, { params });
  }

  createAsync(data: TData): Observable<TOut> {
    const json = Object.assign(data, {});
    return this.http.post<TOut>(`${this.env.apiUrl}/create/${this.route}`, json);
  }

  updateAsync(data: TData): Observable<TOut> {
    const body = Object.assign(data, {})
    return this.http.put<TOut>(`${this.env.apiUrl}/update/${this.route}`, body);
  }

  deleteAsync(id: number): Observable<void> {
    return this.http.delete<void>(`${this.env.apiUrl}/delete/${this.route}/${id}`);
  }
}

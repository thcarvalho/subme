import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { LoginUser } from '../entities/login-user.entity';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  env = environment;

  constructor(private http: HttpClient) {}

  loginAsync(body: LoginUser): Observable<string> {
    return this.http.post<string>(`${this.env.apiUrl}/login`, body);
  }
}

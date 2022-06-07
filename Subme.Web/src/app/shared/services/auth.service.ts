import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import jwtDecode from 'jwt-decode';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { JwtToken } from '../classes/jwt-token';
import { TokenProps } from '../classes/token-props';
import { LoginUser } from '../entities/login-user.entity';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  env = environment;

  constructor(private http: HttpClient) {}

  loginAsync(body: LoginUser): Observable<JwtToken> {
    return this.http.post<any>(`${this.env.apiUrl}/login`, body);
  }

  getToken(): string | null{
    return window.sessionStorage.getItem("@token");
  }

  setToken(token: string): void {
    const { companyId } = jwtDecode(token) as TokenProps;
    window.sessionStorage.setItem("@token", token);
    window.sessionStorage.setItem("@companyId", companyId.toString());
  }

  clearToken(): void {
    window.sessionStorage.removeItem("@token");
    window.sessionStorage.removeItem("@companyId");
  }
}

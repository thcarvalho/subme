import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginUser } from 'src/app/shared/entities/login-user.entity';
import { AuthService } from 'src/app/shared/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  form!: FormGroup;
  isLoading = false;

  constructor(
    private formBuilder: FormBuilder,
    private snackBar: MatSnackBar,
    private authService: AuthService,
    private router: Router

  ) {
    this.form = this.formBuilder.group({
      username: [null, [Validators.required]],
      password: [null, [Validators.required]],
    })
  }

  ngOnInit(): void {
  }

  isFormValid(): boolean {
    const valid = this.form.valid;
    if (!valid) {
      this.form.markAllAsTouched();
      this.snackBar.open("Há campos inválidos no formulário!", undefined, { duration: 3000 })
    }
    return valid;
  }

  async loginAsync(): Promise<void> {
    try {
      this.isLoading = true;
      if (this.isFormValid()) {
        const data = this.form.value as LoginUser;
        const { token } = await this.authService.loginAsync(data).toPromise();
        this.authService.setToken(token);
        this.router.navigate(['dashboard', 'home'])
      }
    } catch ({error}) {
      this.snackBar.open(error as string, undefined, { duration: 3000 });
      console.error(error);
    } finally {
      this.isLoading = false;
    }
  }
}

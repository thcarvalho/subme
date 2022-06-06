import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginUser } from 'src/app/shared/entities/login-user.entity';
import { LoginService } from 'src/app/shared/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  form!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private snackBar: MatSnackBar,
    private loginService: LoginService,
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
      this.snackBar.open("Há campos inválidos no formulário!")
    }
    return valid;
  }

  async loginAsync(): Promise<void> {
    try {
      if (this.isFormValid()) {
        // const data = this.form.value as LoginUser;
        // const token = await this.loginService.loginAsync(data).toPromise();
        window.sessionStorage.setItem("@token", "asdadsasds");
        this.router.navigate(['dashboard', 'home'])
      }
    } catch (error) {
      console.error(error);
    }
  }
}

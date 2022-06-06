import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { SidenavItem } from './interfaces/sidenav-item';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class SidenavComponent implements OnInit {
  items: SidenavItem[] = [];

  constructor(
    private router: Router,
    private authService: AuthService,
  ) {}

  ngOnInit(): void {
    this.setSidenavItems();
  }

  setSidenavItems(): void {
    this.items = [
      { name: 'Inicio', url: 'home', icon: 'home' },
      { name: 'Clientes', url: 'customers', icon: 'people' },
      { name: 'Planos', url: 'plans', icon: 'menu_book' },
      { name: 'Assinaturas', url: 'subscriptions', icon: 'request_page' },
    ];
  }

  logout(): void {
    this.authService.clearToken();
    this.router.navigate(['login'])
  }
}

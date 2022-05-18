import { Component, OnInit } from '@angular/core';
import { SidenavItem } from './interfaces/sidenav-item';

@Component({
  selector: 'app-sidenav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.scss'],
})
export class SidenavComponent implements OnInit {
  items: SidenavItem[] = [];

  constructor() {}

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
}

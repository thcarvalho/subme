import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-subscriptions',
  templateUrl: './subscriptions.component.html',
  styleUrls: ['./subscriptions.component.scss']
})
export class SubscriptionsComponent implements OnInit {
  columns: any[] = [];
  data: any[] = [
    {
      id: 1,
      customer: "João da Silva",
      plan: "Plano Comum",
      status: "Ativo",
    },
    {
      id: 1,
      customer: "João da Silva",
      plan: "Plano Comum",
      status: "Ativo",
    },
    {
      id: 1,
      customer: "João da Silva",
      plan: "Plano Comum",
      status: "Ativo",
    },
    {
      id: 1,
      customer: "João da Silva",
      plan: "Plano Comum",
      status: "Ativo",
    },
    {
      id: 1,
      customer: "João da Silva",
      plan: "Plano Comum",
      status: "Ativo",
    },
    {
      id: 1,
      customer: "João da Silva",
      plan: "Plano Comum",
      status: "Ativo",
    },
  ];

  constructor() {}

  ngOnInit(): void {
    this.setColumns();
  }

  setColumns(): void {
    this.columns = [
      ["id", "ID"],
      ["customer", "CLIENTE"],
      ["plan", "PLANO"],
      ["status", "STATUS"],
    ]
  }
}

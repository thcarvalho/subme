import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-plans',
  templateUrl: './plans.component.html',
  styleUrls: ['./plans.component.scss']
})
export class PlansComponent implements OnInit {
  columns: any[] = [];
  data: any[] = [
    {
      id: 1,
      name: "Plano Comum",
      price: "25.00",
      status: "Ativo"
    },
    {
      id: 1,
      name: "Plano Comum",
      price: "25.00",
      status: "Ativo"
    },
    {
      id: 1,
      name: "Plano Comum",
      price: "25.00",
      status: "Ativo"
    },
    {
      id: 1,
      name: "Plano Comum",
      price: "25.00",
      status: "Ativo"
    },
    {
      id: 1,
      name: "Plano Comum",
      price: "25.00",
      status: "Ativo"
    },
    {
      id: 1,
      name: "Plano Comum",
      price: "25.00",
      status: "Ativo"
    },
    {
      id: 1,
      name: "Plano Comum",
      price: "25.00",
      status: "Ativo"
    },
    {
      id: 1,
      name: "Plano Comum",
      price: "25.00",
      status: "Ativo"
    },
  ];

  constructor() {}

  ngOnInit(): void {
    this.setColumns();
  }

  setColumns(): void {
    this.columns = [
      ["id", "ID"],
      ["name", "NOME"],
      ["price", "PREÇO"],
      ["status", "STATUS"],
    ]
  }

}

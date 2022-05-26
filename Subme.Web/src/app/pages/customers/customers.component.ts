import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.scss'],
})
export class CustomersComponent implements OnInit {
  columns: any[] = [];
  data: any[] = [
    {
      email: 'asd@asd',
      cpf: '123.123.123-12',
      id: 1,
      name: 'abc',
    },
    {
      email: 'asd@asd',
      cpf: '123.123.123-12',
      id: 1,
      name: 'abc',
    },
    {
      email: 'asd@asd',
      cpf: '123.123.123-12',
      id: 1,
      name: 'abc',
    },
    {
      email: 'asd@asd',
      cpf: '123.123.123-12',
      id: 1,
      name: 'abc',
    },
    {
      email: 'asd@asd',
      cpf: '123.123.123-12',
      id: 1,
      name: 'abc',
    },
    {
      email: 'asd@asd',
      cpf: '123.123.123-12',
      id: 1,
      name: 'abc',
    },
    {
      email: 'asd@asd',
      cpf: '123.123.123-12',
      id: 1,
      name: 'abc',
    },
    {
      email: 'asd@asd',
      cpf: '123.123.123-12',
      id: 1,
      name: 'abc',
    },
    {
      email: 'asd@asd',
      cpf: '123.123.123-12',
      id: 1,
      name: 'abc',
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
      ["email", "E-MAIL"]
    ]
  }
}

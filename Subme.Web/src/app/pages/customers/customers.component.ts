import { Component, OnInit } from '@angular/core';
import { ModalConfig } from 'src/app/shared/components/modal/classes/modal-config';
import { ModalService } from 'src/app/shared/components/modal/services/modal.service';
import { TableMenuOptions } from 'src/app/shared/components/table/classes/table-menu-options';
import { CustomersFormComponent } from './customers-form/customers-form.component';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.scss'],
})
export class CustomersComponent implements OnInit {
  columns: any[] = [];
  tableOptions!: TableMenuOptions;
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

  constructor(
    private modalService: ModalService
  ) {}

  ngOnInit(): void {
    this.setTable();
  }

  setTable(): void {
    this.tableOptions = {
      deleteAction: (id) => this.deleteCustomer(id),
      editAction: (id) => this.goToCustomersForm(id)
    };
    this.columns = [
      ["id", "ID"],
      ["name", "NOME"],
      ["email", "E-MAIL"]
    ];
  }

  deleteCustomer(id: number): void {

  }

  goToCustomersForm(id?: number): void {
    const config = new ModalConfig()
    config.componentToRender = CustomersFormComponent;
    config.title = "Novo Cliente";
    config.icon = "people";
    config.data = id ? this.data.find(x => x.id == id) : null;
    this.modalService.open(config);
  }

}

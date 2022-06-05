import { Component, OnInit } from '@angular/core';
import { ConfirmDialogConfig } from 'src/app/shared/components/confirm-dialog/classes/confirm-dialog-config';
import { ConfirmDialogService } from 'src/app/shared/components/confirm-dialog/services/confirm-dialog.service';
import { ModalConfig } from 'src/app/shared/components/modal/classes/modal-config';
import { ModalService } from 'src/app/shared/components/modal/services/modal.service';
import { TableMenuOptions } from 'src/app/shared/components/table/classes/table-menu-options';
import { Customer } from 'src/app/shared/entities/customer.entity';
import { CustomerService } from 'src/app/shared/services/customer.service';
import { CustomersFormComponent } from './customers-form/customers-form.component';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.scss'],
})
export class CustomersComponent implements OnInit {
  columns: any[] = [];
  tableOptions!: TableMenuOptions;
  data!: Customer[];

  constructor(
    private modalService: ModalService,
    private customersService: CustomerService,
    private confirmDialogService: ConfirmDialogService
  ) {}

  async ngOnInit(): Promise<void> {
    await this.getDataAsync();
    this.setTableConfig();
    this.setColumns();
  }

  async getDataAsync(): Promise<void> {
    this.data = await this.customersService.getAllAsync().toPromise();
  }

  setColumns(): void {
    this.columns = [
      ["id", "ID"],
      ["name", "NOME"],
      ["email", "E-MAIL"]
    ];
  }

  setTableConfig(): void {
    this.tableOptions = {
      deleteAction: (id) => this.deleteCustomerAsync(id),
      editAction: (id) => this.goToCustomersForm(id)
    };
  }

  async deleteCustomerAsync(id: number): Promise<void> {
    const config = {
      title: "Confirmar Exclusão",
      message: "Deseja realmente excluir esse cliente?",
    } as ConfirmDialogConfig;
    this.confirmDialogService.open(config);
    this.confirmDialogService.closed.subscribe(async result => {
      if (result) {
        await this.customersService.deleteAsync(id).toPromise();
      }
    })
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

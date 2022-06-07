import { ChangeDetectionStrategy, ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { RequestParams } from 'src/app/shared/classes/params/request-params';
import { ConfirmDialogConfig } from 'src/app/shared/components/confirm-dialog/classes/confirm-dialog-config';
import { ConfirmDialogService } from 'src/app/shared/components/confirm-dialog/services/confirm-dialog.service';
import { ModalConfig } from 'src/app/shared/components/modal/classes/modal-config';
import { ModalService } from 'src/app/shared/components/modal/services/modal.service';
import { SearchInputConfig } from 'src/app/shared/components/search-input/classes/search-input-config';
import { TableMenuOptions } from 'src/app/shared/components/table/classes/table-menu-options';
import { Customer } from 'src/app/shared/entities/customer.entity';
import { CustomerService } from 'src/app/shared/services/customer.service';
import { CustomersFormComponent } from './customers-form/customers-form.component';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class CustomersComponent implements OnInit {
  columns: any[] = [];
  tableOptions!: TableMenuOptions;
  data!: Customer[];
  isLoading = true;
  searchConfig = {
    params: [
      { id: 'name', label: 'Nome' },
      { id: 'email', label: 'E-mail' },
    ],
    searchAction: (search) => this.searchAsync(search),
  } as SearchInputConfig

  constructor(
    private modalService: ModalService,
    private customersService: CustomerService,
    private confirmDialogService: ConfirmDialogService,
    private cdRef: ChangeDetectorRef
  ) {
  }

  async ngOnInit(): Promise<void> {
    await this.refreshTableAsync();
  }

  async getDataAsync(query = new RequestParams()): Promise<void> {
    this.data = await this.customersService
      .getAllAsync(query)
      .toPromise();
  }

  async refreshTableAsync(query = new RequestParams()): Promise<void> {
    this.isLoading = true
    await this.getDataAsync(query);
    this.setTableConfig();
    this.setColumns();
    this.isLoading = false
    this.cdRef.detectChanges();
  }

  setColumns(): void {
    this.columns = [
      ['id', 'ID'],
      ['name', 'NOME'],
      ['email', 'E-MAIL'],
    ];
  }

  setTableConfig(): void {
    this.tableOptions = {
      deleteAction: (id) => this.deleteCustomerAsync(id),
      editAction: (id) => this.goToCustomersForm(id),
    };
  }

  async searchAsync(search: any): Promise<void> {
    try {
      const {param, value} = search;
      const query = {
        param: `${param},${value}`
      } as RequestParams;
      await this.refreshTableAsync(query);
    } catch (error) {
      this.isLoading = false
      console.error(error);
    }
  }

  async deleteCustomerAsync(id: number): Promise<void> {
    const config = {
      title: 'Confirmar Exclusão',
      message: 'Deseja realmente excluir esse cliente?',
    } as ConfirmDialogConfig;
    this.confirmDialogService.open(config);
    this.confirmDialogService.closed.subscribe(async (result) => {
      if (result) {
        await this.customersService.deleteAsync(id).toPromise();
        await this.refreshTableAsync();
      }
    });
  }

  goToCustomersForm(id?: number): void {
    const config = new ModalConfig();
    config.componentToRender = CustomersFormComponent;
    config.title = 'Novo Cliente';
    config.icon = 'people';
    config.data = id ? this.data.find((x) => x.id == id) : null;
    this.modalService.open(config);
    this.modalService.closed.subscribe(async result => {
      if (result) {
        await this.refreshTableAsync();
      }
    })
  }
}

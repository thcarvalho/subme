import { ChangeDetectionStrategy, ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { RequestParams } from 'src/app/shared/classes/params/request-params';
import { ConfirmDialogConfig } from 'src/app/shared/components/confirm-dialog/classes/confirm-dialog-config';
import { ConfirmDialogService } from 'src/app/shared/components/confirm-dialog/services/confirm-dialog.service';
import { ModalConfig } from 'src/app/shared/components/modal/classes/modal-config';
import { ModalService } from 'src/app/shared/components/modal/services/modal.service';
import { SearchInputConfig } from 'src/app/shared/components/search-input/classes/search-input-config';
import { TableMenuOptions } from 'src/app/shared/components/table/classes/table-menu-options';
import { Subscription } from 'src/app/shared/entities/subscription.entity';
import { SubscriptionService } from 'src/app/shared/services/subscription.service';
import { SubscriptionsFormComponent } from './subscriptions-form/subscriptions-form.component';

@Component({
  selector: 'app-subscriptions',
  templateUrl: './subscriptions.component.html',
  styleUrls: ['./subscriptions.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class SubscriptionsComponent implements OnInit {
  columns: any[] = [];
  data!: Subscription[];
  tableOptions!: TableMenuOptions;
  tableData!: any[];
  subscriptionStatus = ["Ativo", "Suspenso", "Cancelado"];
  searchConfig = {
    params: [
      { id: 'name', label: 'Cliente' },
      { id: 'plan', label: 'Plano' },
      { id: 'status', label: 'Status' },
    ],
    searchAction: (search) => this.searchAsync(search),
  } as SearchInputConfig;

  constructor(
    private modalService: ModalService,
    private subscriptionService: SubscriptionService,
    private confirmDialogService: ConfirmDialogService,
    private cdRef: ChangeDetectorRef
  ) {}

  async ngOnInit(): Promise<void> {
    await this.refreshTableAsync();
  }

  async getDataAsync(query = new RequestParams()): Promise<void> {
    this.data = await this.subscriptionService.getAllAsync(query).toPromise();
  }

  async searchAsync(search: any): Promise<void> {
    try {
      const {param, value} = search;
      const query = {
        param: `${param},${value}`
      } as RequestParams;
      await this.refreshTableAsync(query);
    } catch (error) {
      console.error(error);
    }
  }

  async refreshTableAsync(query = new RequestParams()): Promise<void> {
    await this.getDataAsync(query);
    this.setTableData();
    this.setTableConfig();
    this.setColumns();
    this.cdRef.detectChanges();
  }

  setTableData(): void {
    this.tableData = this.data.map((sub) => ({
      id: sub.id,
      customer: sub.customer.name,
      plan: sub.plan.name,
      status: this.subscriptionStatus[sub.status]
    }));
  }

  setColumns(): void {
    this.columns = [
      ['id', 'ID'],
      ['customer', 'CLIENTE'],
      ['plan', 'PLANO'],
      ['status', 'STATUS'],
    ];
  }

  setTableConfig(): void {
    this.tableOptions = {
      deleteAction: (id) => this.deleteSubscriptionAsync(id),
      editAction: (id) => this.goToSubscriptionsForm(id),
    };
  }

  async deleteSubscriptionAsync(id: number): Promise<void> {
    const config = {
      title: "Confirmar Exclusão",
      message: "Deseja realmente excluir essa assinatura?",
    } as ConfirmDialogConfig;
    this.confirmDialogService.open(config);
    this.confirmDialogService.closed.subscribe(async result => {
      if (result) {
        await this.subscriptionService.deleteAsync(id).toPromise();
        await this.refreshTableAsync();
      }
    })
  }

  goToSubscriptionsForm(id?: number): void {
    const config = new ModalConfig();
    config.componentToRender = SubscriptionsFormComponent;
    config.title = 'Nova Assinatura';
    config.icon = 'request_page';
    config.data = id ? this.data.find((x) => x.id == id) : null;
    this.modalService.open(config)
    this.modalService.closed.subscribe(async result => {
      if (result) {
        await this.refreshTableAsync();
      }
    })
  }
}

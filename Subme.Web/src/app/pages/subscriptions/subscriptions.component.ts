import { Component, OnInit } from '@angular/core';
import { ConfirmDialogConfig } from 'src/app/shared/components/confirm-dialog/classes/confirm-dialog-config';
import { ConfirmDialogService } from 'src/app/shared/components/confirm-dialog/services/confirm-dialog.service';
import { ModalConfig } from 'src/app/shared/components/modal/classes/modal-config';
import { ModalService } from 'src/app/shared/components/modal/services/modal.service';
import { TableMenuOptions } from 'src/app/shared/components/table/classes/table-menu-options';
import { Subscription } from 'src/app/shared/entities/subscription.entity';
import { SubscriptionStatus } from 'src/app/shared/enums/subscription-status.enum';
import { SubscriptionService } from 'src/app/shared/services/subscription.service';
import { SubscriptionsFormComponent } from './subscriptions-form/subscriptions-form.component';

@Component({
  selector: 'app-subscriptions',
  templateUrl: './subscriptions.component.html',
  styleUrls: ['./subscriptions.component.scss'],
})
export class SubscriptionsComponent implements OnInit {
  columns: any[] = [];
  data = [
    {
      id: 1,
      customer: {
        email: 'asd@asd',
        cpf: '123.123.123-12',
        id: 1,
        name: 'João da Silva',
        address: {
          zipcode: '03828160',
          country: 'Brasil',
          state: 'SP',
          city: 'São Paulo',
          street: 'Rua ABC',
          number: '11',
        },
      },
      plan: {
        id: 1,
        name: 'Plano Comum',
        price: '25.00',
        isActive: true,
        description: 'Descrição do plano',
      },
      status: SubscriptionStatus.active,
    },
  ] as Subscription[];
  tableOptions!: TableMenuOptions;
  tableData!: any[];
  subscriptionStatus = ["Ativo", "Suspenso", "Cancelado"];

  constructor(
    private modalService: ModalService,
    private subscriptionService: SubscriptionService,
    private confirmDialogService: ConfirmDialogService
  ) {}

  async ngOnInit(): Promise<void> {
    await this.getDataAsync();
    this.setTableData();
    this.setTableConfig();
    this.setColumns();
  }

  async getDataAsync(): Promise<void> {
    this.data = await this.subscriptionService.getAllAsync().toPromise();
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
      }
    })
  }

  goToSubscriptionsForm(id?: number): void {
    const config = new ModalConfig();
    config.componentToRender = SubscriptionsFormComponent;
    config.title = 'Nova Assinatura';
    config.icon = 'request_page';
    config.data = id ? this.data.find((x) => x.id == id) : null;
    this.modalService.open(config);
  }
}

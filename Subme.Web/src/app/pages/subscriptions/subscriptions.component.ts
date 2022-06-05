import { Component, OnInit } from '@angular/core';
import { ModalConfig } from 'src/app/shared/components/modal/classes/modal-config';
import { ModalService } from 'src/app/shared/components/modal/services/modal.service';
import { SubscriptionsFormComponent } from './subscriptions-form/subscriptions-form.component';

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

  constructor(
    private modalService: ModalService
  ) {}

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

  goToSubscriptionsForm(): void {
    const config = new ModalConfig()
    config.componentToRender = SubscriptionsFormComponent;
    config.title = "Nova Assinatura";
    config.icon = "request_page"
    this.modalService.open(config);
  }
}

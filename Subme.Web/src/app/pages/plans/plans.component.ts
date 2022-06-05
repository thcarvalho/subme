import { Component, OnInit } from '@angular/core';
import { ModalConfig } from 'src/app/shared/components/modal/classes/modal-config';
import { ModalService } from 'src/app/shared/components/modal/services/modal.service';
import { PlansFormComponent } from './plans-form/plans-form.component';

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

  constructor(
    private modalService: ModalService
  ) {}

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

  goToPlansForm(): void {
    const config = new ModalConfig()
    config.componentToRender = PlansFormComponent;
    config.title = "Novo Plano";
    config.icon = "menu_book";
    this.modalService.open(config);
  }

}

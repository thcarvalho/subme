import { ChangeDetectionStrategy, ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { RequestParams } from 'src/app/shared/classes/params/request-params';
import { ConfirmDialogConfig } from 'src/app/shared/components/confirm-dialog/classes/confirm-dialog-config';
import { ConfirmDialogService } from 'src/app/shared/components/confirm-dialog/services/confirm-dialog.service';
import { ModalConfig } from 'src/app/shared/components/modal/classes/modal-config';
import { ModalService } from 'src/app/shared/components/modal/services/modal.service';
import { SearchInputConfig } from 'src/app/shared/components/search-input/classes/search-input-config';
import { TableMenuOptions } from 'src/app/shared/components/table/classes/table-menu-options';
import { Plan } from 'src/app/shared/entities/plan.entity';
import { PlanService } from 'src/app/shared/services/plan.service';
import { PlansFormComponent } from './plans-form/plans-form.component';

@Component({
  selector: 'app-plans',
  templateUrl: './plans.component.html',
  styleUrls: ['./plans.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class PlansComponent implements OnInit {
  columns: any[] = [];
  data!: Plan[];
  tableOptions!: TableMenuOptions;
  tableData!: any[]
  isLoading = true;
  searchConfig = {
    params: [
      { id: 'name', label: 'Nome' },
    ],
    searchAction: (search) => this.searchAsync(search),
  } as SearchInputConfig

  constructor(
    private modalService: ModalService,
    private planService: PlanService,
    private confirmDialogService: ConfirmDialogService,
    private cdRef: ChangeDetectorRef
  ) { }

  async ngOnInit(): Promise<void> {
    await this.refreshTableAsync();
  }

  async getDataAsync(query = new RequestParams()): Promise<void> {
    this.data = await this.planService.getAllAsync(query).toPromise();
    this.cdRef.detectChanges();
  }

  async searchAsync(search: any): Promise<void> {
    try {
      const {param, value} = search;
      const query = {
        param: `${param},${value}`
      } as RequestParams;
      await this.getDataAsync(query);
      await this.refreshTableAsync(query);
    } catch (error) {
      this.isLoading = false;
      console.error(error);
    }
  }

  setTableData(): void {
    this.tableData = this.data.map(plan => ({ status: plan.isActive ? "Ativo" : "Inativo", ...plan }));
  }

  setTableConfig(): void {
    this.tableOptions = {
      deleteAction: (id) => this.deletePlanAsync(id),
      editAction: (id) => this.goToPlansForm(id)
    };
  }

  setColumns(): void {
    this.columns = [
      ["id", "ID"],
      ["name", "NOME"],
      ["price", "PREÇO"],
      ["status", "STATUS"],
    ]
  }

  async refreshTableAsync(query = new RequestParams()): Promise<void> {
    this.isLoading = true;
    await this.getDataAsync(query);
    this.setTableConfig();
    this.setTableData();
    this.setColumns();
    this.isLoading = false;
    this.cdRef.detectChanges();
  }

  async deletePlanAsync(id: number): Promise<void> {
    const config = {
      title: "Confirmar Exclusão",
      message: "Deseja realmente excluir esse plano?",
    } as ConfirmDialogConfig;
    this.confirmDialogService.open(config);
    this.confirmDialogService.closed.subscribe(async result => {
      if (result) {
        await this.planService.deleteAsync(id).toPromise();
        await this.refreshTableAsync();
      }
    })
  }

  goToPlansForm(id?: number): void {
    const config = new ModalConfig()
    config.componentToRender = PlansFormComponent;
    config.title = "Novo Plano";
    config.icon = "menu_book";
    config.data = id ? this.data.find(x => x.id == id) : null;
    this.modalService.open(config);
    this.modalService.closed.subscribe(async result => {
      if (result) {
        await this.refreshTableAsync();
      }
    })
  }

}

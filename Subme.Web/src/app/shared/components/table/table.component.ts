import { ChangeDetectionStrategy, ChangeDetectorRef, Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { BaseEntity } from '../../entities/base.entity';
import { ModalService } from '../modal/services/modal.service';
import { TableMenuOptions } from './classes/table-menu-options';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class TableComponent implements OnInit, OnChanges {
  @Input() columns: any[][] = [];
  @Input() data: BaseEntity[] = [];
  @Input() menuOptions!: TableMenuOptions;

  dataSource!: MatTableDataSource<BaseEntity>;
  displayedColumns: string[] = [];

  constructor(
    public modalService: ModalService,
    private cdRef: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.refresh();
  }

  ngOnChanges(changes: SimpleChanges | this): void {
    if (changes.data) {
      this.refresh();
    }
  }

  getKeys(data: any[]): void {
    if (data && data.length > 0) {
      this.displayedColumns = this.columns.map(c => c[0])
      this.displayedColumns = this.displayedColumns.concat(['actions']);
    }
  }

  refresh(): void {
    if (this.data) {
      this.dataSource = new MatTableDataSource(this.data);
      this.getKeys(this.data);
    }
    this.cdRef.detectChanges();
  }

  onDelete(id: number): void {
    this.menuOptions.deleteAction(id);
    this.refresh();
  }

  onEdit(id: number): void {
    this.menuOptions.editAction(id);
    this.refresh();
  }
}

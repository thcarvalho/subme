import { Component, Input, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss'],
})
export class TableComponent implements OnInit {
  @Input() columns: any[][] = [];
  @Input() data: any[] = [];
  @Input() menuOptions: any[][] = [];

  dataSource!: MatTableDataSource<any>;
  displayedColumns: string[] = [];

  constructor() {}

  ngOnInit(): void {
    this.refresh();
  }

  getKeys(data: any[]): void {
    if (data && data.length > 0) {
      this.displayedColumns = this.columns.map(c => c[0])
      if (this.menuOptions && this.menuOptions.length > 0) {
        this.displayedColumns = this.displayedColumns.concat(['menu']);
      }
    }
  }

  refresh(): void {
    if (this.data) {
      this.dataSource = new MatTableDataSource(this.data);
      this.getKeys(this.data);
    }
  }
}

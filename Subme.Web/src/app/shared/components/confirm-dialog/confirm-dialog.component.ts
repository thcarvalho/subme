import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ConfirmDialogConfig } from './classes/confirm-dialog-config';

@Component({
  selector: 'app-confirm-dialog',
  templateUrl: './confirm-dialog.component.html',
  styleUrls: ['./confirm-dialog.component.scss']
})
export class ConfirmDialogComponent implements OnInit {

  constructor(
    @Inject(MAT_DIALOG_DATA) public config: ConfirmDialogConfig,
    private matDialogRef: MatDialogRef<ConfirmDialogComponent>,
  ) { }

  ngOnInit(): void {
  }

  confirm(confirmed: boolean): void {
    this.matDialogRef.close(confirmed);
  }
}

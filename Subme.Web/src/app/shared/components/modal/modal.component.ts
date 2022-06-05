import { Component, Inject, Input, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ModalConfig } from './classes/modal-config';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.scss']
})
export class ModalComponent implements OnInit {

  constructor(
    @Inject(MAT_DIALOG_DATA) public config: ModalConfig,
    private matDialogRef: MatDialogRef<ModalComponent>,
  ) { }

  ngOnInit(): void {
  }

  close(): void {
    this.matDialogRef.close();
  }
}

import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ModalConfig } from 'src/app/shared/components/modal/classes/modal-config';

@Component({
  selector: 'app-plans-form',
  templateUrl: './plans-form.component.html',
  styleUrls: ['./plans-form.component.scss']
})
export class PlansFormComponent implements OnInit {

  constructor(
    @Inject(MAT_DIALOG_DATA) public config: ModalConfig,
  ) { }

  ngOnInit(): void {
  }

  savePlan(): void {

  }
}

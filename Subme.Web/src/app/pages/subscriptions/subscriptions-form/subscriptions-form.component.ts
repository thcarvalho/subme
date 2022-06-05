import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ModalConfig } from 'src/app/shared/components/modal/classes/modal-config';

@Component({
  selector: 'app-subscriptions-form',
  templateUrl: './subscriptions-form.component.html',
  styleUrls: ['./subscriptions-form.component.scss']
})
export class SubscriptionsFormComponent implements OnInit {

  constructor(
    @Inject(MAT_DIALOG_DATA) public config: ModalConfig,
  ) { }

  ngOnInit(): void {
  }

  saveSubscription(): void {
  }

}

import { EventEmitter, Injectable } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Observable } from 'rxjs';
import { ModalConfig } from '../classes/modal-config';
import { ModalComponent } from '../modal.component';

@Injectable({
  providedIn: 'root'
})
export class ModalService {

  closed = new EventEmitter<any>();

  constructor(
    private matDialog: MatDialog
  ) { }

  open<TData, TOutput>(config: ModalConfig): Observable<TOutput | undefined> {
    const data: ModalConfig<TData> = { ...config };
    const bottomSheet = this.matDialog.open<ModalComponent, ModalConfig<TData>, TOutput>(ModalComponent, {...config, data});
    return bottomSheet.afterClosed();
  }
}

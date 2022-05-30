import { EventEmitter, Injectable } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ModalConfig } from '../classes/modal-config';
import { take } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class ModalService {
  closed = new EventEmitter<any>();

  constructor(private matDialog: MatDialog) {}

  open(config: ModalConfig): void {
    const data: ModalConfig = { ...config };
    const dialog = this.matDialog.open(config.componentToRender, { ...config, data });

    dialog.afterClosed()
      .pipe(take(1))
      .subscribe((result: boolean) => {
        this.closed.emit(result);
      });
  }
}

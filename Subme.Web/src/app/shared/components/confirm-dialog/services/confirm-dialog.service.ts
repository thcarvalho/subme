import { EventEmitter, Injectable } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { take } from 'rxjs/operators';
import { ConfirmDialogConfig } from '../classes/confirm-dialog-config';
import { ConfirmDialogComponent } from '../confirm-dialog.component';

@Injectable({
  providedIn: 'root'
})
export class ConfirmDialogService {
  closed = new EventEmitter<boolean>();

  constructor(private matDialog: MatDialog) {}

  open(data: ConfirmDialogConfig): void {
    const dialog = this.matDialog.open(ConfirmDialogComponent, { data });

    dialog.afterClosed()
      .pipe(take(1))
      .subscribe((result: boolean) => {
        this.closed.emit(result);
      });
  }
}

import { MatDialogConfig } from "@angular/material/dialog";

export class ModalConfig<T = any> extends MatDialogConfig<T> {
  data?: T;
  title!: string;
  icon!: string;
}

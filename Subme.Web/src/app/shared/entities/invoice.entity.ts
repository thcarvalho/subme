import { BaseEntity } from "./base.entity";
import { Subscription } from "./subscription.entity";

export class Invoice extends BaseEntity {
  dueDate!: Date;
  wasPaid!: boolean;
  value!: number;
  description!: string;
  subscription!: Subscription;
}

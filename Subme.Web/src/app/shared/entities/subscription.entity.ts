import { SubscriptionStatus } from "../enums/subscription-status.enum";
import { BaseEntity } from "./base.entity";
import { Customer } from "./customer.entity";
import { Plan } from "./plan.entity";

export class Subscription extends BaseEntity {
  customer!: Customer;
  plan!: Plan;
  status!: SubscriptionStatus;
}

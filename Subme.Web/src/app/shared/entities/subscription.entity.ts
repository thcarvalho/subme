import { SubscriptionStatus } from "../enums/subscription-status.enum";
import { BaseEntity } from "./base.entity";

export class Subscription extends BaseEntity {
  customerId!: number;
  planId!: number;
  status!: SubscriptionStatus;
}

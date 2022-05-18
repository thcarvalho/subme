import { Address } from "./address.entity";
import { BaseEntity } from "./base.entity";
import { Subscription } from "./subscription.entity";

export class Customer extends BaseEntity {
  cpf!: string;
  address!: Address;
  subscriptions!: Subscription[];
  email!: string;
	name!: string;
}

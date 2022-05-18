import { Address } from "./address.entity";
import { BaseEntity } from "./base.entity";

export class Company extends BaseEntity {
  cnpj!: string;
  address!: Address;
  email!: string;
	name!: string;
	username!: string;
  password!: string;
}

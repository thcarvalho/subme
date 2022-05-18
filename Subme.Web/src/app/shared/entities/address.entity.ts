import { BaseEntity } from "./base.entity";

export class Address extends BaseEntity {
  street!: string;
  city!: string;
  state!: string;
  country!: string;
  zipcode!: string;
  number!: number;
}

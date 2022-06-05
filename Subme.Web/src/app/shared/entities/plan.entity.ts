import { BaseEntity } from "./base.entity";

export class Plan extends BaseEntity {
  name!: string;
  price!: string;
  isActive!: boolean;
  description!: string;
  companyId!: number;
}

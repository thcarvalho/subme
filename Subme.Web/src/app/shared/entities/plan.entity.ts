import { BaseEntity } from "./base.entity";

export class Plan extends BaseEntity {
  name!: string;
  price!: number;
  isActive!: boolean;
  description!: string;
}

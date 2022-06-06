import { AddressForm } from "./address.form";

export class CustomerForm {
  id?: number;
  customer!: {
    cpf: string;
    name: string;
    email: string;
    address: AddressForm;
    companyId: number;
  };
  plan!: {
    id: number;
  };
}

import { AddressForm } from "./address.form";

export class CustomerForm {
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

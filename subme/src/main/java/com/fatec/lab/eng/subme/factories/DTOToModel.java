package com.fatec.lab.eng.subme.factories;

import com.fatec.lab.eng.subme.dto.*;
import com.fatec.lab.eng.subme.entities.*;

public class DTOToModel {
    public static AddressEntity addressFactory(AddressDTO dto) {
        AddressEntity entity = new AddressEntity();
        return entity;
    }

    public static CompanyEntity companyFactory(CompanyDTO dto) {
        return new CompanyEntity();
    }

    public static CustomerEntity customerFactory(CustomerDTO dto) {
        return new CustomerEntity();
    }

    public static InvoiceEntity invoiceFactory(InvoiceDTO dto) {
        return new InvoiceEntity();
    }

    public static PlanEntity planFactory(PlanDTO dto) {
        return new PlanEntity();
    }

    public static SubscriptionEntity subscriptionFactory(SubscriptionDTO dto) {
        return new SubscriptionEntity();
    }
}

package com.fatec.lab.eng.subme.factories;

import com.fatec.lab.eng.subme.dto.*;
import com.fatec.lab.eng.subme.entities.*;

public class DTOToModel {
    public static AdressEntity addressFactory(AddressDTO dto) {
        AdressEntity entity = new AdressEntity();
        return entity;
    }

    public static CompanyEntity companyFactory(CompanyDTO dto) {
        return new CompanyEntity();
    }

    public static CustumerEntity customerFactory(CustomerDTO dto) {
        return new CustumerEntity();
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

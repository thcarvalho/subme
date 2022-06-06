package com.fatec.lab.eng.subme.factories;

import com.fatec.lab.eng.subme.dto.*;
import com.fatec.lab.eng.subme.entities.*;

public class ModelToDTO {
    public static AddressDTO addressFactory(AddressEntity entity) {
        return new AddressDTO(entity);
    }

    public static CompanyDTO companyFactory(CompanyEntity entity) {
        return new CompanyDTO(entity);
    }

    public static CustomerDTO customerFactory(CustomerEntity entity) {
        return new CustomerDTO(entity);
    }

    public static InvoiceDTO invoiceFactory(InvoiceEntity entity) {
        return new InvoiceDTO();
    }

    public static PlanDTO planFactory(PlanEntity entity) {
        return new PlanDTO(entity);
    }

    public static SubscriptionDTO subscriptionFactory(SubscriptionEntity entity, CustomerDTO customerDTO, PlanDTO planDTO) {
        return new SubscriptionDTO(entity, customerDTO, planDTO);
    }
}

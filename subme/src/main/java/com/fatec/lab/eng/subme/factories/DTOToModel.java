package com.fatec.lab.eng.subme.factories;

import com.fatec.lab.eng.subme.dto.*;
import com.fatec.lab.eng.subme.entities.*;

public class DTOToModel {
    public static CompanyEntity companyFactory(CompanyDTO dto, UserEntity user) {
        return new CompanyEntity(dto, user);
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

    public static UserEntity userFactory(String name, String email, String username, String password) {
        return new UserEntity(name, email, username, password);
    }

    public static SubscriptionEntity subscriptionFactory(SubscriptionDTO dto) {
        return new SubscriptionEntity();
    }

    public static AddressEntity addressFactory(AddressDTO dto){
        return new AddressEntity(dto);
    }
}

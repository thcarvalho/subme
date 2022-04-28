package com.fatec.lab.eng.subme.services;

import com.fatec.lab.eng.subme.dto.CompanyDTO;
import com.fatec.lab.eng.subme.dto.CustomerDTO;
import com.fatec.lab.eng.subme.entities.CompanyEntity;
import com.fatec.lab.eng.subme.entities.CustumerEntity;
import com.fatec.lab.eng.subme.factories.DTOToModel;
import com.fatec.lab.eng.subme.factories.ModelToDTO;
import com.fatec.lab.eng.subme.repositories.CustomerRepository;
import com.fatec.lab.eng.subme.services.interfaces.ICustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements ICustomerService {
    private CustomerRepository customerRepository;

    public CustomerService() {
        this.customerRepository = new CustomerRepository();
    }

    @Override
    public List<CustomerDTO> GetAll() {
        List<CustumerEntity> custumers = customerRepository.GetAll();
        List<CustomerDTO> dtos = new ArrayList<>();
        for (CustumerEntity entity : custumers) {
            dtos.add(ModelToDTO.customerFactory(entity));
        }
        return dtos;
    }

    @Override
    public CustomerDTO GetById(int id) {
        CustumerEntity custumer = customerRepository.GetById(id);
        return ModelToDTO.customerFactory(custumer);
    }

    @Override
    public void Add(CustomerDTO model) {
        CustumerEntity custumer = DTOToModel.customerFactory(model);
        customerRepository.Add(custumer);
    }

    @Override
    public void Update(CustomerDTO model, int id) {
        CustumerEntity current = customerRepository.GetById(id);
        if (current == null) return;

        CustumerEntity updated = DTOToModel.customerFactory(model);
        customerRepository.Update(updated, id);
    }

    @Override
    public void Delete(int id) {
        CustumerEntity custumer = customerRepository.GetById(id);
        if (custumer == null) return;

        customerRepository.Delete(id);
    }
}

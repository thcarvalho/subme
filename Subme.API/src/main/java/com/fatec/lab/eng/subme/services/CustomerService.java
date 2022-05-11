package com.fatec.lab.eng.subme.services;

import com.fatec.lab.eng.subme.dto.CompanyDTO;
import com.fatec.lab.eng.subme.dto.CustomerDTO;
import com.fatec.lab.eng.subme.entities.CompanyEntity;
import com.fatec.lab.eng.subme.entities.CustomerEntity;
import com.fatec.lab.eng.subme.entities.CustomerEntity;
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
        List<CustomerEntity> customers = customerRepository.GetAll();
        List<CustomerDTO> dtos = new ArrayList<>();
        for (CustomerEntity entity : customers) {
            dtos.add(ModelToDTO.customerFactory(entity));
        }
        return dtos;
    }

    @Override
    public CustomerDTO GetById(int id) {
        CustomerEntity customer = customerRepository.GetById(id);
        return ModelToDTO.customerFactory(customer);
    }

    @Override
    public void Add(CustomerDTO model) {
        CustomerEntity customer = DTOToModel.customerFactory(model);
        customerRepository.Add(customer);
    }

    @Override
    public void Update(CustomerDTO model, int id) {
        CustomerEntity current = customerRepository.GetById(id);
        if (current == null) return;

        CustomerEntity updated = DTOToModel.customerFactory(model);
        customerRepository.Update(updated, id);
    }

    @Override
    public void Delete(int id) {
        CustomerEntity customer = customerRepository.GetById(id);
        if (customer == null) return;

        customerRepository.Delete(id);
    }
}

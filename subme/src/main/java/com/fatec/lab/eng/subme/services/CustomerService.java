package com.fatec.lab.eng.subme.services;

import com.fatec.lab.eng.subme.dto.CustomerDTO;
import com.fatec.lab.eng.subme.entities.CustomerEntity;
import com.fatec.lab.eng.subme.factories.ModelToDTO;
import com.fatec.lab.eng.subme.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerDTO> toList(){
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (CustomerEntity entity : customerRepository.findAll()){
            customerDTOS.add(ModelToDTO.customerFactory(entity));
        }
        return customerDTOS;
    }


}

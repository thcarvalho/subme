package com.fatec.lab.eng.subme.services;

import com.fatec.lab.eng.subme.dto.CustomerDTO;
import com.fatec.lab.eng.subme.dto.SubscriptionDTO;
import com.fatec.lab.eng.subme.entities.CustomerEntity;
import com.fatec.lab.eng.subme.entities.PlanEntity;
import com.fatec.lab.eng.subme.factories.DTOToModel;
import com.fatec.lab.eng.subme.factories.ModelToDTO;
import com.fatec.lab.eng.subme.repositories.AddressRepository;
import com.fatec.lab.eng.subme.repositories.CustomerRepository;
import com.fatec.lab.eng.subme.repositories.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private PlanRepository planRepository;

    public ResponseEntity<?> update(CustomerDTO customerDTO){
        if(!customerRepository.existsById(customerDTO.getId())){
            return ResponseEntity.badRequest().body("Cliente ainda não cadastrado!");
        }
        CustomerEntity customerEntity = DTOToModel.customerFactory(customerDTO);
        addressRepository.save(customerEntity.getaddress());
        customerRepository.save(customerEntity);
        return ResponseEntity.ok().body(customerEntity);
    }

    public ResponseEntity<?> delete(Long id){
        if(!customerRepository.existsById(id)){
            return ResponseEntity.badRequest().body("Cliente ainda não cadastrado!");
        }
        CustomerEntity customerEntity = customerRepository.findById(id).get();
        customerEntity.setStatus(false);
        customerRepository.save(customerEntity);
        return ResponseEntity.ok().body(customerEntity);
    }

    public ResponseEntity<?> create(SubscriptionDTO subscriptionDTO, Long CompanyId){
        if(customerRepository.existsByCpf(subscriptionDTO.getCustomer().getCpf())){
            return ResponseEntity.badRequest().body("CPF ou CNPJ já cadastrado!");
        }
        CustomerEntity customerEntity = DTOToModel.customerFactory(subscriptionDTO.getCustomer());
        customerEntity.setStatus(true);
        customerEntity.setCompanyId(CompanyId);
        addressRepository.save(customerEntity.getaddress());
        customerRepository.save(customerEntity);
        //PlanEntity planEntity = planRepository.findByName(subscriptionDTO.getPlan().getName());
        PlanEntity planEntity = planRepository.findById(subscriptionDTO.getPlan().getId()).get();
        return ResponseEntity.ok().body(subscriptionService.create(customerEntity, planEntity, 1));
    }

    public List<CustomerDTO> toList(List<CustomerEntity> customers){
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (CustomerEntity entity : customers){
            customerDTOS.add(ModelToDTO.customerFactory(entity));
        }
        return customerDTOS;
    }

    public ResponseEntity<List<CustomerDTO>> filterList(List<String> param){
        List<CustomerEntity> response = null;
        if(param.size() == 2){
            String var, value;
            var = param.get(0).toLowerCase();
            value = param.get(1).toLowerCase();
            switch (var){
                case "name":
                    response = customerRepository.findByNameContainingIgnoreCase(value);
                    break;
                case "cpf":
                    response = customerRepository.findByCpfContainingIgnoreCase(value);
                    break;
                case "email":
                    response = customerRepository.findByEmailContainingIgnoreCase(value);
                    break;
                default:
                    return null;
            }
        }
        return ResponseEntity.ok().body(toList(response));
    }
    public List<CustomerDTO> toList(Long companyId){
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (CustomerEntity entity : customerRepository.findAllByCompanyId(companyId)){
            customerDTOS.add(ModelToDTO.customerFactory(entity));
        }
        return customerDTOS;
    }


}

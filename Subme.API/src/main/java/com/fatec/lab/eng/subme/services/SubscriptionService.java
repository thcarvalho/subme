package com.fatec.lab.eng.subme.services;

import com.fatec.lab.eng.subme.dto.CustomerDTO;
import com.fatec.lab.eng.subme.dto.PlanDTO;
import com.fatec.lab.eng.subme.dto.SubscriptionDTO;
import com.fatec.lab.eng.subme.entities.CustomerEntity;
import com.fatec.lab.eng.subme.entities.PlanEntity;
import com.fatec.lab.eng.subme.entities.SubscriptionEntity;
import com.fatec.lab.eng.subme.factories.DTOToModel;
import com.fatec.lab.eng.subme.factories.ModelToDTO;
import com.fatec.lab.eng.subme.repositories.CustomerRepository;
import com.fatec.lab.eng.subme.repositories.PlanRepository;
import com.fatec.lab.eng.subme.repositories.SubscriptionRepository;
import com.fatec.lab.eng.subme.utils.SubscriptionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PlanRepository planRepository;


    public ResponseEntity<?> update(SubscriptionDTO subscriptionDTO){
        if (!subscriptionRepository.existsById(subscriptionDTO.getId())) ResponseEntity.badRequest().body("Inscrição não existe");
        SubscriptionEntity subscriptionEntity = DTOToModel.subscriptionFactory(subscriptionDTO.getCustomer(), subscriptionDTO.getPlan(), subscriptionDTO.getStatus(), subscriptionDTO.getCompanyId());
        subscriptionRepository.save(subscriptionEntity);
        return ResponseEntity.ok().body(subscriptionEntity);
    }

    public ResponseEntity<?> create(CustomerEntity customerEntity, PlanEntity planEntity, int status){
        SubscriptionEntity subscriptionEntity = new SubscriptionEntity(customerEntity, planEntity, status);
        subscriptionRepository.save(subscriptionEntity);
        return ResponseEntity.ok().body(subscriptionEntity);
    }

    public ResponseEntity<?> createWithCustomerRegistered(CustomerDTO customerDTO, PlanDTO planDTO, int status, Long companyId){
        SubscriptionEntity subscriptionEntity = DTOToModel.subscriptionFactory(customerDTO, planDTO, status, companyId);
        subscriptionRepository.save(subscriptionEntity);
        return ResponseEntity.ok().body(subscriptionEntity);
    }

    public ResponseEntity<?> createWithCustomerRegistered(SubscriptionDTO subscriptionDTO, Long companyId){
        if(!customerRepository.existsById(subscriptionDTO.getCustomer().getId())){
            return ResponseEntity.badRequest().body("CPF ou CNPJ não cadastrado!");
        }
        return ResponseEntity.ok().body(createWithCustomerRegistered(subscriptionDTO.getCustomer(), subscriptionDTO.getPlan(), 1, companyId));
    }

    public List<SubscriptionDTO> toList(Long companyId){
        List<SubscriptionDTO> subscriptionDTOS = new ArrayList<>();
        for (SubscriptionEntity entity : subscriptionRepository.findAllByCompanyId(companyId)){
            CustomerDTO customerDTO = ModelToDTO.customerFactory(customerRepository
                    .findById(entity.getCustomerId()).get());
            PlanDTO planDTO = ModelToDTO.planFactory(planRepository
                    .findById(entity.getPlanId()).get());
            subscriptionDTOS.add(ModelToDTO.subscriptionFactory(entity, customerDTO, planDTO));
        }
        return subscriptionDTOS;
    }

    public List<SubscriptionDTO> toList(List<SubscriptionEntity> subscriptions){
        List<SubscriptionDTO> subscriptionDTOS = new ArrayList<>();
        for (SubscriptionEntity entity : subscriptions){
            CustomerDTO customerDTO = ModelToDTO.customerFactory(customerRepository
                    .findById(entity.getCustomerId()).get());
            PlanDTO planDTO = ModelToDTO.planFactory(planRepository
                    .findById(entity.getPlanId()).get());
            subscriptionDTOS.add(ModelToDTO.subscriptionFactory(entity, customerDTO, planDTO));
        }
        return subscriptionDTOS;
    }

    public ResponseEntity<List<SubscriptionDTO>> filteredList(List<String> param, Long companyId) {
        if(param.size() == 2) {
            String var, value;
            var = param.get(0).toLowerCase();
            value = param.get(1).toLowerCase();
            switch (var){
                case "name":
                    List<CustomerEntity> responseC = new ArrayList<>();
                    responseC = customerRepository.findByNameContainingIgnoreCase(value);
                    Set<CustomerEntity> customers = new HashSet<>();
                    responseC.stream()
                                    .filter(customerEntity -> customerEntity.getCompanyId() == companyId &&
                                            customerEntity.isStatus())
                                    .forEach(customers::add);
                    List<SubscriptionEntity> filteredListSubscriptionByCustomer = new ArrayList<>();
                    customers.stream()
                                    .forEach(customerEntity -> filteredListSubscriptionByCustomer.addAll(subscriptionRepository.findByCustomerId(customerEntity.getId())));

                    return ResponseEntity.ok().body(toList(filteredListSubscriptionByCustomer));
                case "plan":
                    List<PlanEntity> responseP = new ArrayList<>();
                    responseP = planRepository.findByNameContainingIgnoreCase(value);
                    Set<PlanEntity> plans = new HashSet<>();
                    responseP.stream()
                            .filter(planEntity -> planEntity.getCompanyEntity() == companyId)
                            .forEach(plans::add);
                    List<SubscriptionEntity> filteredListSubscriptionByPlan = new ArrayList<>();
                    plans.stream()
                            .forEach(planEntity -> filteredListSubscriptionByPlan.addAll(subscriptionRepository.findByPlanId(planEntity.getId())));
                    return ResponseEntity.ok().body(toList(filteredListSubscriptionByPlan));
                case "status":
                    int status;
                    if ("active".contains(value) || Long.parseLong(value) == 1){
                        status = SubscriptionStatus.ACTIVE.value;
                    } else if("suspended".contains(value) || Long.parseLong(value) == 2){
                        status = SubscriptionStatus.SUSPENDED.value;
                    } else if ("canceled".contains(value) || Long.parseLong(value) == 3){
                        status = SubscriptionStatus.CANCELED.value;
                    } else {
                        return null;
                    }
                    List<SubscriptionEntity> filteredListSubscriptionByStatus = new ArrayList<>();
                    filteredListSubscriptionByStatus = subscriptionRepository.findByStatus(status);
                    return ResponseEntity.ok().body(toList(filteredListSubscriptionByStatus));
                default:
                    return null;
            }

        }
        return null;
    }

    public ResponseEntity<List<SubscriptionDTO>> filterList(List<String> param){
        List<SubscriptionEntity> response = new ArrayList<>();
        ArrayList<CustomerEntity> responseC;
        ArrayList<PlanEntity> responseP;
        if(param.size() == 2){
            String var, value;
            var = param.get(0).toLowerCase();
            value = param.get(1).toLowerCase();
            switch (var){
                case "name":
                    responseC = customerRepository.findByNameContainingIgnoreCase(value);
                    Set<CustomerEntity> customers = new HashSet<>();
                    customers.addAll(responseC);
                    for(CustomerEntity customer : customers) response.addAll(subscriptionRepository.findByCustomerId(customer.getId()));
                    break;
                case "plan":
                    responseP = planRepository.findByNameContainingIgnoreCase(value);
                    Set<PlanEntity> plans = new HashSet<>();
                    plans.addAll(responseP);
                    for (PlanEntity plan : plans) response.addAll(subscriptionRepository.findByPlanId(plan.getId()));
                    break;
                case "status":
                    int status;
                    if ("active".contains(value)){
                        status = SubscriptionStatus.ACTIVE.value;
                    } else if("suspended".contains(value)){
                        status = SubscriptionStatus.SUSPENDED.value;
                    } else if ("canceled".contains(value)){
                        status = SubscriptionStatus.CANCELED.value;
                    } else {
                        return null;
                    }
                    response = subscriptionRepository.findByStatus(status);
                    break;
                default:
                    return null;
            }
        }
        return ResponseEntity.ok().body(toList(response));
    }


}

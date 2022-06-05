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

    public ResponseEntity<?> create(CustomerEntity customerEntity, PlanEntity planEntity, int status){
        SubscriptionEntity subscriptionEntity = DTOToModel.subscriptionFactory(customerEntity, planEntity, status);
        subscriptionRepository.save(subscriptionEntity);
        return ResponseEntity.ok().body(subscriptionEntity);
    }

    public List<SubscriptionDTO> toList(){
        List<SubscriptionDTO> subscriptionDTOS = new ArrayList<>();
        for (SubscriptionEntity entity : subscriptionRepository.findAll()){
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

    public ResponseEntity<List<SubscriptionDTO>> filterList(List<String> param){
        List<SubscriptionEntity> response = new ArrayList<>();
        ArrayList<CustomerEntity> responseC = new ArrayList<>();
        ArrayList<PlanEntity> responseP = new ArrayList<>();
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

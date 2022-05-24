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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}

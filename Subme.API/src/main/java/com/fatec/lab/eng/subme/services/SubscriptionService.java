package com.fatec.lab.eng.subme.services;

import com.fatec.lab.eng.subme.dto.CustomerDTO;
import com.fatec.lab.eng.subme.dto.SubscriptionDTO;
import com.fatec.lab.eng.subme.entities.CustomerEntity;
import com.fatec.lab.eng.subme.entities.SubscriptionEntity;
import com.fatec.lab.eng.subme.factories.ModelToDTO;
import com.fatec.lab.eng.subme.repositories.CustomerRepository;
import com.fatec.lab.eng.subme.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public List<SubscriptionDTO> toList(){
        List<SubscriptionDTO> subscriptionDTOS = new ArrayList<>();
        for (SubscriptionEntity entity : subscriptionRepository.findAll()){
            subscriptionDTOS.add(ModelToDTO.subscriptionFactory(entity));
        }
        return subscriptionDTOS;
    }
}

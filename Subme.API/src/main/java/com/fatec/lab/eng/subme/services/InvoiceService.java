package com.fatec.lab.eng.subme.services;

import com.fatec.lab.eng.subme.dto.CustomerDTO;
import com.fatec.lab.eng.subme.dto.InvoiceDTO;
import com.fatec.lab.eng.subme.dto.PlanDTO;
import com.fatec.lab.eng.subme.dto.SubscriptionDTO;
import com.fatec.lab.eng.subme.entities.CustomerEntity;
import com.fatec.lab.eng.subme.entities.InvoiceEntity;
import com.fatec.lab.eng.subme.entities.PlanEntity;
import com.fatec.lab.eng.subme.entities.SubscriptionEntity;
import com.fatec.lab.eng.subme.factories.DTOToModel;
import com.fatec.lab.eng.subme.factories.ModelToDTO;
import com.fatec.lab.eng.subme.repositories.CustomerRepository;
import com.fatec.lab.eng.subme.repositories.InvoiceRepository;
import com.fatec.lab.eng.subme.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    /*public ResponseEntity<?> create(Long subscriptionId){
        List<SubscriptionEntity> subscriptionEntities = subscriptionRepository.findBySubscriptionId(subscriptionId);
        if(subscriptionEntities.size() < 1){

        }

        if(planRepository.existsByName(planDTO.getName())){
            return ResponseEntity.badRequest().body("Nome já cadastrado!");
        }
        PlanEntity planEntity = DTOToModel.planFactory(planDTO);
        planRepository.save(planEntity);
        return ResponseEntity.ok().body(planEntity);
    }*/

    public List<InvoiceDTO> toList(){
        List<InvoiceDTO> invoiceDTOS = new ArrayList<>();
        for (InvoiceEntity entity : invoiceRepository.findAll()){
            invoiceDTOS.add(ModelToDTO.invoiceFactory(entity));
        }
        return invoiceDTOS;
    }
}

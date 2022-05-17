package com.fatec.lab.eng.subme.services;

import com.fatec.lab.eng.subme.dto.InvoiceDTO;
import com.fatec.lab.eng.subme.dto.PlanDTO;
import com.fatec.lab.eng.subme.entities.InvoiceEntity;
import com.fatec.lab.eng.subme.entities.PlanEntity;
import com.fatec.lab.eng.subme.factories.ModelToDTO;
import com.fatec.lab.eng.subme.repositories.InvoiceRepository;
import com.fatec.lab.eng.subme.repositories.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanService {
    @Autowired
    private PlanRepository planRepository;

    public List<PlanDTO> toList(){
        List<PlanDTO> planDTOS = new ArrayList<>();
        for (PlanEntity entity : planRepository.findAll()){
            planDTOS.add(ModelToDTO.planFactory(entity));
        }
        return planDTOS;
    }
}

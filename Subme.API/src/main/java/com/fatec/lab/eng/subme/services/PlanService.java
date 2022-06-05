package com.fatec.lab.eng.subme.services;

import com.fatec.lab.eng.subme.dto.CompanyDTO;
import com.fatec.lab.eng.subme.dto.CustomerDTO;
import com.fatec.lab.eng.subme.dto.InvoiceDTO;
import com.fatec.lab.eng.subme.dto.PlanDTO;
import com.fatec.lab.eng.subme.entities.*;
import com.fatec.lab.eng.subme.factories.DTOToModel;
import com.fatec.lab.eng.subme.factories.ModelToDTO;
import com.fatec.lab.eng.subme.repositories.InvoiceRepository;
import com.fatec.lab.eng.subme.repositories.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanService {
    @Autowired
    private PlanRepository planRepository;

    public ResponseEntity<?> create(PlanDTO planDTO){
        if(planRepository.existsByName(planDTO.getName())){
            return ResponseEntity.badRequest().body("Nome já cadastrado!");
        }
        PlanEntity planEntity = DTOToModel.planFactory(planDTO);
        planRepository.save(planEntity);
        return ResponseEntity.ok().body(planEntity);
    }
    public List<PlanDTO> toList(List<PlanEntity> plans){
        List<PlanDTO> planDTOS = new ArrayList<>();
        for (PlanEntity entity : plans){
            planDTOS.add(ModelToDTO.planFactory(entity));
        }
        return planDTOS;
    }

    public ResponseEntity<List<PlanDTO>> filterList(List<String> param){
        List<PlanEntity> response = null;
        if(param.size() == 2){
            String var, value;
            var = param.get(0).toLowerCase();
            value = param.get(1).toLowerCase();
            switch (var){
                case "name":
                    response = planRepository.findByNameContainingIgnoreCase(value);
                    break;
                case "status":
                    boolean status;
                    if("true".contains(value)){
                        status = true;
                    } else {
                        status = false;
                    }
                    response = planRepository.findByStatus(status);
                    break;
                default:
                    return null;
            }
        }
        return ResponseEntity.ok().body(toList(response));
    }
}

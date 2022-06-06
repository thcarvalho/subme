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

    public ResponseEntity<?> update(PlanDTO planDTO){
        if(!planRepository.existsById(planDTO.getId())){
            return ResponseEntity.badRequest().body("Não cadastrado!");
        }
        PlanEntity planEntity = DTOToModel.planFactory(planDTO);
        planRepository.save(planEntity);
        return ResponseEntity.ok().body(planEntity);
    }

    public ResponseEntity<?> create(PlanDTO planDTO){
        if(planRepository.existsByName(planDTO.getName())){
            return ResponseEntity.badRequest().body("Nome já cadastrado!");
        }
        PlanEntity planEntity = DTOToModel.planFactory(planDTO);
        planRepository.save(planEntity);
        return ResponseEntity.ok().body(planEntity);
    }

    public ResponseEntity<?> delete(Long id){
        if(!planRepository.existsById(id)){
            return ResponseEntity.badRequest().body("Plano ainda não cadastrado!");
        }
        PlanEntity planEntity = planRepository.findById(id).get();
        planEntity.setStatus(false);
        planRepository.save(planEntity);
        return ResponseEntity.ok().body(planEntity);
    }

    public ResponseEntity<List<PlanDTO>> filteredList(List<String> param, Long companyId){
        List<PlanDTO> filteredListPlan = new ArrayList<>(), filterListPlan = new ArrayList<>();
        filterListPlan.addAll(toList(companyId));
        if(param.size() == 2) {
            String var, value;
            var = param.get(0).toLowerCase();
            value = param.get(1).toLowerCase();
            switch (var){
                case "name":
                    filterListPlan.stream()
                            .dropWhile(planDTO -> planDTO.getName() == null)
                            .filter(planDTO -> planDTO.getName().toLowerCase().contains(value))
                            .forEach(filteredListPlan::add);
                    break;
                case "status":
                    filterListPlan.stream()
                            .filter(planDTO -> String.valueOf(planDTO.getIsActive()).contains(value))
                            .forEach(filteredListPlan::add);
                    break;
                default:
                    return null;
            }

        }
        return ResponseEntity.ok().body(filteredListPlan);
    }

    public List<PlanDTO> toList(Long companyId){
        List<PlanDTO> planDTOS = new ArrayList<>();
        for (PlanEntity entity : planRepository.findAllByCompanyId(companyId)){
            planDTOS.add(ModelToDTO.planFactory(entity));
        }
        return planDTOS;
    }

}

package com.fatec.lab.eng.subme.services;

import com.fatec.lab.eng.subme.dto.PlanDTO;
import com.fatec.lab.eng.subme.repositories.PlanRepository;
import com.fatec.lab.eng.subme.services.interfaces.IPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlanService implements IPlanService {
    private PlanRepository planRepository;

    @Autowired
    public PlanService() {
        this.planRepository = new PlanRepository();
    }

    @Override
    public List<PlanDTO> GetAll() {
        return null;
    }

    @Override
    public PlanDTO GetById(int id) {
        return null;
    }

    @Override
    public void Add(PlanDTO model) {

    }

    @Override
    public void Update(PlanDTO model, int id) {

    }

    @Override
    public void Delete(int id) {

    }
}

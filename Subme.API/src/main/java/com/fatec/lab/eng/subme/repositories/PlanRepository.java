package com.fatec.lab.eng.subme.repositories;

import com.fatec.lab.eng.subme.entities.CustomerEntity;
import com.fatec.lab.eng.subme.entities.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface PlanRepository extends JpaRepository<PlanEntity, Long> {
    boolean existsByName(String name);
    ArrayList<PlanEntity> findByNameContainingIgnoreCase(String name);

    List<PlanEntity> findAllByCompanyId(Long companyId);
    List<PlanEntity> findByStatus(boolean status);
}

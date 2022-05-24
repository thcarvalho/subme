package com.fatec.lab.eng.subme.repositories;

import com.fatec.lab.eng.subme.entities.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<PlanEntity, Long> {
    boolean existsByName(String name);

    PlanEntity findByName(String name);
}

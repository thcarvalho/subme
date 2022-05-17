package com.fatec.lab.eng.subme.repositories;

import com.fatec.lab.eng.subme.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
    boolean existsByCnpj(String cnpj);
}

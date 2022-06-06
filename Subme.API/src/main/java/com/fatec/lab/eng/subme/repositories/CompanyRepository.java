package com.fatec.lab.eng.subme.repositories;

import com.fatec.lab.eng.subme.entities.CompanyEntity;
import com.fatec.lab.eng.subme.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
    boolean existsByCnpj(String cnpj);
    CompanyEntity findByUserEntity(UserEntity user);

}

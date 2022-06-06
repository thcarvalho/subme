package com.fatec.lab.eng.subme.repositories;

import com.fatec.lab.eng.subme.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    boolean existsByCpf(String cpf);
    List<CustomerEntity> findByCpfContainingIgnoreCase(String cpf);
    ArrayList<CustomerEntity> findByNameContainingIgnoreCase(String name);
    List<CustomerEntity> findByEmailContainingIgnoreCase(String email);

    List<CustomerEntity> findAllByCompanyId(Long companyId);
}

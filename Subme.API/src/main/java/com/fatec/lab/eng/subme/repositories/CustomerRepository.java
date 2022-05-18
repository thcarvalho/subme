package com.fatec.lab.eng.subme.repositories;

import com.fatec.lab.eng.subme.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

}

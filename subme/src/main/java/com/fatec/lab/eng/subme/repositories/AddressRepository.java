package com.fatec.lab.eng.subme.repositories;

import com.fatec.lab.eng.subme.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}

package com.fatec.lab.eng.subme.repositories;

import com.fatec.lab.eng.subme.entities.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {
}

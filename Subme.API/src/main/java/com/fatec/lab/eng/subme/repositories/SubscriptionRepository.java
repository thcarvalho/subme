package com.fatec.lab.eng.subme.repositories;

import com.fatec.lab.eng.subme.entities.SubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {
}

package com.fatec.lab.eng.subme.repositories;

import com.fatec.lab.eng.subme.entities.SubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {
    boolean existsBySubscriptionId(Long subscriptionId);
    List<SubscriptionEntity> findBySubscriptionId(Long subscriptionId);
}

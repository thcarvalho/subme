package com.fatec.lab.eng.subme.repositories;

import com.fatec.lab.eng.subme.entities.SubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {

    List<SubscriptionEntity> findByCustomerId(Long customerId);
    List<SubscriptionEntity> findByPlanId(Long planId);
    List<SubscriptionEntity> findByStatus(int status);

    //@Query(value = "Select s.id_subscription, c.name as customer, p.name as plan, s.status from subscriptions s inner JOIN customers c on s.id_customer = c.id_customer JOIN plans p on s.id_plan = p.id_plan where c.name like concat('%', ?1, '%')", nativeQuery = true);
    //List<SubscriptionEntity> findAllByCustomerName(String name);
}

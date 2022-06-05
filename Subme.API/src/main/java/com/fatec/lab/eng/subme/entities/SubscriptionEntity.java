package com.fatec.lab.eng.subme.entities;

import com.fatec.lab.eng.subme.dto.CustomerDTO;
import com.fatec.lab.eng.subme.dto.PlanDTO;
import com.fatec.lab.eng.subme.utils.SubscriptionStatus;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "subscriptions")
public class SubscriptionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subscription")
    private Long id;

    @Column(name = "id_customer")
    private Long customerId;

    @Column(name = "id_plan")
    private Long planId;

    @Column(name = "status")
    private int status;

    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;

    @LastModifiedDate
    @Column(name ="updated_at")
    private Date updatedAt;

    public SubscriptionEntity() {
    }

    public SubscriptionEntity(CustomerEntity customerEntity, PlanEntity planEntity, int status) {
        this.customerId = customerEntity.getId();
        this.planId = planEntity.getId();
        this.status = status;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public SubscriptionEntity(CustomerDTO customerDTO, PlanDTO planDTO, int status) {
        this.customerId = customerDTO.getId();
        this.planId = planDTO.getId();
        this.status = status;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}

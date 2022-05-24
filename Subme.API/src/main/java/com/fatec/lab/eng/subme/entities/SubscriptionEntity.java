package com.fatec.lab.eng.subme.entities;

import com.fatec.lab.eng.subme.dto.PlanDTO;
import com.fatec.lab.eng.subme.utils.SubscriptionStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "subscriptions")
public class SubscriptionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_customer")
    private Long customerId;

    @Column(name = "id_plan")
    private Long planId;

    @Column(name = "status")
    private int status;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name ="updated_at")
    private Date updatedAt;

    public SubscriptionEntity() {
    }

    public SubscriptionEntity(CustomerEntity customerEntity, PlanEntity planEntity, int status) {
        this.customerId = customerEntity.getId();
        this.planId = planEntity.getId();
        this.status = status;
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

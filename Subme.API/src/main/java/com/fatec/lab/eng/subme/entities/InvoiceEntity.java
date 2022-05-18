package com.fatec.lab.eng.subme.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "invoices")
public class InvoiceEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "was_paid")
    private boolean wasPaid;

    @Column(name = "value")
    private double value;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_subscription")
    private SubscriptionEntity subscription;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name ="updated_at")
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isWasPaid() {
        return wasPaid;
    }

    public void setWasPaid(boolean wasPaid) {
        this.wasPaid = wasPaid;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SubscriptionEntity getSubscriptionDTO() {
        return subscription;
    }

    public void setSubscriptionDTO(SubscriptionEntity subscription) {
        this.subscription = subscription;
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

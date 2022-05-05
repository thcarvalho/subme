package com.fatec.lab.eng.subme.entities;

import com.fatec.lab.eng.subme.dto.Subscription;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "INVOICES")
public class InvoiceEntity{
    @Id
    private Long id;

    @Column(name = "DUE_DATE")
    private Date dueDate;

    @Column(name = "WAS_PAID")
    private boolean wasPaid;

    @Column(name = "VALUE")
    private double value;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "SUBSCRIPTION")
    private Subscription subscription;

    @Column(name = "DAT_CREATE")
    private Date createdAt;

    @Column(name ="DAT_UPDATE")
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

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
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

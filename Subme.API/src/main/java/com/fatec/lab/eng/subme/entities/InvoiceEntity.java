package com.fatec.lab.eng.subme.entities;

import com.fatec.lab.eng.subme.dto.InvoiceDTO;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "invoices")
public class InvoiceEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_invoice")
    private Long id;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "was_paid")
    private boolean wasPaid;

    @Column(name = "value")
    private double value;

    @Column(name = "description")
    private String description;


    @Column(name = "id_subscription")
    private Long subscription;

    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;

    @LastModifiedDate
    @Column(name ="updated_at")
    private Date updatedAt;

    public InvoiceEntity() {
    }

    public InvoiceEntity(InvoiceDTO invoiceDTO) {
        this.id = invoiceDTO.getId();
        this.dueDate = invoiceDTO.getDueDate();
        this.wasPaid = invoiceDTO.isWasPaid();
        this.value = invoiceDTO.getValue();
        this.description = invoiceDTO.getDescription();
        this.subscription = invoiceDTO.getSubscription();
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

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

    public Long getSubscription() {
        return subscription;
    }

    public void setSubscription(Long subscription) {
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

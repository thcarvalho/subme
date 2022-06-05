package com.fatec.lab.eng.subme.entities;

import com.fatec.lab.eng.subme.dto.PlanDTO;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "plans")
public class PlanEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plan")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "status")
    private boolean status;

    @Column(name = "description")
    private String description;

    @Column(name = "id_company")
    private Long companyId;

    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;

    @LastModifiedDate
    @Column(name ="updated_at")
    private Date updatedAt;

    public PlanEntity(){
    }
    public PlanEntity(PlanDTO planDTO) {
        this.id = planDTO.getId();
        this.name = planDTO.getName();
        this.price = planDTO.getPrice();
        this.status = planDTO.getIsActive();
        this.description = planDTO.getDescription();
        this.companyId = planDTO.getCompanyId();
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCompanyEntity() {
        return companyId;
    }

    public void setCompanyEntity(Long companyEntity) {
        this.companyId = companyEntity;
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

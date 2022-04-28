package com.fatec.lab.eng.subme.entities;

import com.fatec.lab.eng.subme.dto.Adress;
import com.fatec.lab.eng.subme.dto.Customer;
import com.fatec.lab.eng.subme.dto.Plan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "COMPANIES")
public class CompanyEntity {
    @Id
    private Long id;

    @Column(name = "CNPJ")
    private String cnpj;

    @Column(name = "ADRESS")
    private Adress adress;

    @Column(name = "PLAN")
    private List<Plan> plans;

    @Column(name = "COSTUMER")
    private List<Customer> costumers;

    @Column(name = "DAT_CREATE")
    private Date createdAt;

    @Column(name ="DAT_UPDATE")
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }

    public List<Customer> getCostumers() {
        return costumers;
    }

    public void setCostumers(List<Customer> costumers) {
        this.costumers = costumers;
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

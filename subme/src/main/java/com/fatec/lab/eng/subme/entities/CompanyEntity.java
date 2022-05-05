package com.fatec.lab.eng.subme.entities;

import com.fatec.lab.eng.subme.dto.Adress;
import com.fatec.lab.eng.subme.dto.Customer;
import com.fatec.lab.eng.subme.dto.Plan;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "companies")
public class CompanyEntity {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cpf_cnpj")
    private String cnpj;

    @OneToOne
    @JoinColumn(name = "id_adress")
    private Adress adress;

    @OneToMany
    @JoinColumn(name = "id_plan")
    private List<Plan> plans;
    @OneToMany
    @JoinColumn(name = "id_customer")
    private List<Customer> customers;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name ="updated_at")
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

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
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

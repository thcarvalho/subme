package com.fatec.lab.eng.subme.entities;

import com.fatec.lab.eng.subme.dto.AddressDTO;
import com.fatec.lab.eng.subme.dto.CustomerDTO;
import com.fatec.lab.eng.subme.dto.PlanDTO;

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
    private AddressDTO adress;

    @OneToMany
    @JoinColumn(name = "id_plan")
    private List<PlanDTO> plans;
    @OneToMany
    @JoinColumn(name = "id_customer")
    private List<CustomerDTO> customers;

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

    public AddressDTO getAdress() {
        return adress;
    }

    public void setAdress(AddressDTO adress) {
        this.adress = adress;
    }

    public List<PlanDTO> getPlans() {
        return plans;
    }

    public void setPlans(List<PlanDTO> plans) {
        this.plans = plans;
    }

    public List<CustomerDTO> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerDTO> customers) {
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

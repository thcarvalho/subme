package com.fatec.lab.eng.subme.entities;

import com.fatec.lab.eng.subme.dto.AddressDTO;
import com.fatec.lab.eng.subme.dto.SubscriptionDTO;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customers")
public class CustomerEntity {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cpf_cnpj")
    private String cpf;

    @OneToOne
    @JoinColumn(name = "id_adress")
    private AddressDTO adress;

    //TODO
    @OneToMany
    @JoinColumn(name = "id_subscription")
    private List<SubscriptionDTO> subscriptions;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name ="updated_at")
    private Date updatedAt;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public AddressDTO getAdress() {
        return adress;
    }

    public void setAdress(AddressDTO adress) {
        this.adress = adress;
    }

    public List<SubscriptionDTO> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<SubscriptionDTO> subscriptions) {
        this.subscriptions = subscriptions;
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

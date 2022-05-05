package com.fatec.lab.eng.subme.entities;

import com.fatec.lab.eng.subme.dto.Adress;
import com.fatec.lab.eng.subme.dto.Subscription;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "COSTUMERS")
public class CustumerEntity {
    @Id
    private Long id;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "ADRESS")
    private Adress adress;

    @Column(name = "SUBSCRIPTION")
    private List<Subscription> subscriptions;

    @Column(name = "DAT_CREATE")
    private Date createdAt;

    @Column(name ="DAT_UPDATE")
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
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

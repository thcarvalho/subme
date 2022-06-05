package com.fatec.lab.eng.subme.entities;

import com.fatec.lab.eng.subme.dto.AddressDTO;
import com.fatec.lab.eng.subme.dto.CustomerDTO;
import com.fatec.lab.eng.subme.dto.SubscriptionDTO;
import com.fatec.lab.eng.subme.factories.DTOToModel;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customers")
public class CustomerEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cpf")
    private String cpf;

    @OneToOne
    @JoinColumn(name = "id_address")
    private AddressEntity address;

    @JoinColumn(name = "id_company")
    private Long idCompany;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private boolean status;

    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;

    @LastModifiedDate
    @Column(name ="updated_at")
    private Date updatedAt;

    public CustomerEntity() {
    }

    public CustomerEntity(CustomerDTO customerDTO) {
        this.id = customerDTO.getId();
        this.name = customerDTO.getName();
        this.cpf = customerDTO.getCpf();
        this.address = DTOToModel.addressFactory(customerDTO.getAddress());
        this.idCompany = customerDTO.getCompanyId();
        this.email = customerDTO.getEmail();
        this.status = customerDTO.isStatus();
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public AddressEntity getaddress() {
        return address;
    }

    public void setaddress(AddressEntity address) {
        this.address = address;
    }

    public Long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Long idCompany) {
        this.idCompany = idCompany;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }


    public Date getUpdatedAt() {
        return updatedAt;
    }

}

package com.fatec.lab.eng.subme.entities;

import com.fatec.lab.eng.subme.dto.AddressDTO;
import com.fatec.lab.eng.subme.dto.CustomerDTO;
import com.fatec.lab.eng.subme.dto.SubscriptionDTO;
import com.fatec.lab.eng.subme.factories.DTOToModel;

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
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cpf_cnpj")
    private String cpf;

    @OneToOne
    @JoinColumn(name = "id_adress")
    private AddressEntity adress;


    @JoinColumn(name = "id_company")
    private Long idCompany;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name ="updated_at")
    private Date updatedAt;

    public CustomerEntity() {
    }

    public CustomerEntity(CustomerDTO customerDTO) {
        this.id = customerDTO.getId();
        this.name = customerDTO.getName();
        this.cpf = customerDTO.getCpf();
        this.adress = DTOToModel.addressFactory(customerDTO.getAddress());
        this.idCompany = customerDTO.getCompanyId();
        this.createdAt = customerDTO.getCreatedAt();
        this.updatedAt = customerDTO.getUpdatedAt();
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

    public AddressEntity getAdress() {
        return adress;
    }

    public void setAdress(AddressEntity adress) {
        this.adress = adress;
    }

    public Long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Long idCompany) {
        this.idCompany = idCompany;
    }

    public Date getCreatedAt() {
        return createdAt;
    }


    public Date getUpdatedAt() {
        return updatedAt;
    }

}

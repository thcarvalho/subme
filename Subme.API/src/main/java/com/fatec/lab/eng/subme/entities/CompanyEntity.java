package com.fatec.lab.eng.subme.entities;

import com.fatec.lab.eng.subme.dto.CompanyDTO;
import com.fatec.lab.eng.subme.factories.DTOToModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "companies")
public class CompanyEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cpf_cnpj")
    private String cnpj;

    @OneToOne
    @JoinColumn(name = "id_adress")
    private AddressEntity adress;

    @OneToOne
    @JoinColumn(name = "id_user")
    private UserEntity userEntity;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name ="updated_at")
    private Date updatedAt;

    public CompanyEntity() {
    }

    public CompanyEntity(CompanyDTO companyDTO, UserEntity userEntity) {

        this.id = companyDTO.getId();
        this.name = companyDTO.getName();
        this.cnpj = companyDTO.getCnpj();
        this.adress = DTOToModel.addressFactory(companyDTO.getAddress());
        this.userEntity = userEntity;
        this.createdAt = companyDTO.getCreatedAt();
        this.updatedAt = companyDTO.getUpdatedAt();
    }

    public Long getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public AddressEntity getAdress() {
        return adress;
    }

    public void setAdress(AddressEntity adress) {
        this.adress = adress;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
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

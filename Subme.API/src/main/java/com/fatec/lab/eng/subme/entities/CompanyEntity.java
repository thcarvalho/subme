package com.fatec.lab.eng.subme.entities;

import com.fatec.lab.eng.subme.dto.CompanyDTO;
import com.fatec.lab.eng.subme.factories.DTOToModel;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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
    @Column(name = "id_company")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cpf_cnpj")
    private String cnpj;


    @Column(name = "id_address")
    private AddressEntity address;

    @Column(name = "id_user")
    private UserEntity userEntity;

    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;

    @LastModifiedDate
    @Column(name ="updated_at")
    private Date updatedAt;

    public CompanyEntity() {
    }

    public CompanyEntity(CompanyDTO companyDTO, UserEntity userEntity) {

        this.id = companyDTO.getId();
        this.name = companyDTO.getName();
        this.cnpj = companyDTO.getCnpj();
        this.address = DTOToModel.addressFactory(companyDTO.getAddress());
        this.userEntity = userEntity;
        this.createdAt = new Date();
        this.updatedAt = new Date();
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

    public AddressEntity getaddress() {
        return address;
    }

    public void setaddress(AddressEntity address) {
        this.address = address;
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

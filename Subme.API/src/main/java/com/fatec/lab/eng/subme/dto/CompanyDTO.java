package com.fatec.lab.eng.subme.dto;

import com.fatec.lab.eng.subme.entities.CompanyEntity;
import com.fatec.lab.eng.subme.factories.ModelToDTO;

import java.util.List;

public class CompanyDTO extends UserDTO{
	private String cnpj;
	private AddressDTO address;

	public CompanyDTO() {}

	public CompanyDTO(String cnpj, String name, String email, AddressDTO address,
					  String username, String password) {
		this.cnpj = cnpj;
		this.setName(name);
		this.setEmail(email);
		this.address = address;
		this.setUsername(username);
		this.setPassword(password);
	}

	public CompanyDTO(CompanyEntity companyEntity) {
		this.setId(companyEntity.getId());
		this.cnpj = companyEntity.getCnpj();
		this.setName(companyEntity.getUserEntity().getName());
		this.setEmail(companyEntity.getUserEntity().getEmail());
		this.address = ModelToDTO.addressFactory(companyEntity.getaddress());
		this.setUsername(companyEntity.getUserEntity().getUsername());
		this.setPassword(companyEntity.getUserEntity().getPassword());
		this.setCreatedAt(companyEntity.getCreatedAt());
		this.setUpdatedAt(companyEntity.getUpdatedAt());
	}

	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	}

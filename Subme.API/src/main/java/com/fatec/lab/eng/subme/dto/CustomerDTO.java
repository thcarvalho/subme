package com.fatec.lab.eng.subme.dto;

import com.fatec.lab.eng.subme.entities.CustomerEntity;
import com.fatec.lab.eng.subme.factories.ModelToDTO;

import java.util.List;

public class CustomerDTO extends UserDTO {
	private String cpf;
	private AddressDTO address;

	private boolean status;
	private Long companyId;

	public CustomerDTO() {}

	public CustomerDTO(CustomerEntity customerEntity) {
		this.setId(customerEntity.getId());
		this.setName(customerEntity.getName());
		this.cpf = customerEntity.getCpf();
		this.address = ModelToDTO.addressFactory(customerEntity.getaddress());
		this.companyId = customerEntity.getIdCompany();
		this.setEmail(customerEntity.getEmail());
		this.status = customerEntity.isStatus();
		this.setCreatedAt(customerEntity.getCreatedAt());
		this.setUpdatedAt(customerEntity.getUpdatedAt());
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}

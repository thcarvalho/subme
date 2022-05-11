package com.fatec.lab.eng.subme.dto;

import java.util.List;

public class CompanyDTO extends SystemUserDTO {
	private String cnpj;
	private AddressDTO adress;
	private List<PlanDTO> plans;
	private List<CustomerDTO> customers;

	public CompanyDTO() {}

	public CompanyDTO(String cnpj, AddressDTO adress, List<PlanDTO> plans, List<CustomerDTO> customers) {
		this.cnpj = cnpj;
		this.adress = adress;
		this.plans = plans;
		this.customers = customers;
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
	}

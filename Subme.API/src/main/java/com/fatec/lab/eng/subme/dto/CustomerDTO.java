package com.fatec.lab.eng.subme.dto;

import java.util.List;

public class CustomerDTO extends UserDTO {
	private String cpf;
	private AddressDTO address;
	private List<SubscriptionDTO> subscriptions;

	public CustomerDTO() {}

	public CustomerDTO(String cpf, AddressDTO address, List<SubscriptionDTO> subscriptions) {
		this.cpf = cpf;
		this.address = address;
		this.subscriptions = subscriptions;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public AddressDTO getAdress() {
		return address;
	}
	public void setAdress(AddressDTO adress) {
		this.address = adress;
	}
	public List<SubscriptionDTO> getSubscriptions() {
		return subscriptions;
	}
	public void setSubscriptions(List<SubscriptionDTO> subscriptions) {
		this.subscriptions = subscriptions;
	}
	
}

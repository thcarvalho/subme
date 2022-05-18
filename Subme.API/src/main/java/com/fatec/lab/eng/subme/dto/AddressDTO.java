package com.fatec.lab.eng.subme.dto;

import com.fatec.lab.eng.subme.entities.AddressEntity;

public class AddressDTO extends RegisterDTO {
	private String street;
	private int number;
	private String city;
	private String state;
	private String country;
	private String zipcode;

	public AddressDTO() {}

	public AddressDTO(String street, int number, String city, String state,
					  String country, String zipcode) {
		this.street = street;
		this.number = number;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
	}

	public AddressDTO(AddressEntity addressEntity){
		this.setId(addressEntity.getId());
		this.street = addressEntity.getStreet();
		this.number = addressEntity.getNumber();
		this.city = addressEntity.getCity();
		this.state = addressEntity.getState();
		this.country = addressEntity.getCountry();
		this.zipcode = addressEntity.getZipcode();
		this.setCreatedAt(addressEntity.getCreatedAt());
		this.setUpdatedAt(addressEntity.getUpdatedAt());
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}
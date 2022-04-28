package com.fatec.lab.eng.subme.dto;

public class AddressDTO extends RegisterDTO {
	private String street;
	private int number;
	private String city;
	private String state;
	private String zipcode;

	public AddressDTO() {}

	public AddressDTO(String street, int number, String city, String state, String zipcode) {
		this.street = street;
		this.number = number;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
}

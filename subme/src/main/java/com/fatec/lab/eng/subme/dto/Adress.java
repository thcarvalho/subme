package com.fatec.lab.eng.subme.dto;

public class Adress extends Register{
	private String street;
	private int number;
	private String additionalAdress;
	private String city;
	private String state;
	private String country;
	private String zipcode;

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

	public String getAdditionalAdress() {
		return additionalAdress;
	}

	public void setAdditionalAdress(String additionalAdress) {
		this.additionalAdress = additionalAdress;
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

package com.fatec.lab.eng.subme.dto;

public class PlanDTO extends RegisterDTO {
	private String name;
	private double price;
	private boolean isActive;
	private String description;

	public PlanDTO() {}

	public PlanDTO(String name, double price, boolean isActive, String description) {
		this.name = name;
		this.price = price;
		this.isActive = isActive;
		this.description = description;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}

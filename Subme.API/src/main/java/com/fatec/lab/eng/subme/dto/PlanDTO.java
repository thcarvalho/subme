package com.fatec.lab.eng.subme.dto;

import com.fatec.lab.eng.subme.entities.PlanEntity;

public class PlanDTO extends RegisterDTO {
	private String name;
	private double price;
	private boolean isActive;
	private String description;

    private Long companyId;

	public PlanDTO() {}

    public PlanDTO(String name, double price, boolean isActive, String description, Long companyId) {
        this.name = name;
        this.price = price;
        this.isActive = isActive;
        this.description = description;
        this.companyId = companyId;
    }

    public PlanDTO(PlanEntity planEntity) {
        this.setId(planEntity.getId());
        this.name = planEntity.getName();
        this.price = planEntity.getPrice();
        this.isActive = planEntity.isStatus();
        this.description = planEntity.getDescription();
        this.companyId = planEntity.getCompanyEntity();
        this.setCreatedAt(planEntity.getCreatedAt());
        this.setUpdatedAt(planEntity.getUpdatedAt());
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

    public boolean getIsActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}

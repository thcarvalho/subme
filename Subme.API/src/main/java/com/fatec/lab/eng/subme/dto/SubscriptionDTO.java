package com.fatec.lab.eng.subme.dto;

import com.fatec.lab.eng.subme.entities.SubscriptionEntity;

public class SubscriptionDTO extends RegisterDTO {
	private CustomerDTO customer;
	private PlanDTO plan;
	private int status;

	private Long companyId;

	public SubscriptionDTO() {}

	public SubscriptionDTO(SubscriptionEntity subscriptionEntity, CustomerDTO customerDTO, PlanDTO planDTO) {
		this.setId(subscriptionEntity.getId());
		this.customer = customerDTO;
		this.plan = planDTO;
		this.companyId = subscriptionEntity.getCompanyId();
		this.status = subscriptionEntity.getStatus();
		this.setCreatedAt(subscriptionEntity.getCreatedAt());
		this.setUpdatedAt(subscriptionEntity.getUpdatedAt());
	}

	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	public PlanDTO getPlan() {
		return plan;
	}
	public void setPlan(PlanDTO plan) {
		this.plan = plan;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
}

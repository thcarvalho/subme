package com.fatec.lab.eng.subme.dto;

public class SubscriptionDTO extends RegisterDTO {
	private long customerId;
	private long planId;
	private SubscriptionStatusDTO status;

	public SubscriptionDTO() {}

	public SubscriptionDTO(long customerId, long planId, SubscriptionStatusDTO status) {
		this.customerId = customerId;
		this.planId = planId;
		this.status = status;
	}

	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public long getPlanId() {
		return planId;
	}
	public void setPlanId(long planId) {
		this.planId = planId;
	}
	public SubscriptionStatusDTO getStatus() {
		return status;
	}
	public void setStatus(SubscriptionStatusDTO status) {
		this.status = status;
	}
}

package com.fatec.lab.eng.subme.dto;

import com.fatec.lab.eng.subme.utils.SubscriptionStatus;

public class Subscription extends Register{
	private long customerId;
	private long planId;
	private SubscriptionStatus status;
	
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
	public SubscriptionStatus getStatus() {
		return status;
	}
	public void setStatus(SubscriptionStatus status) {
		this.status = status;
	}
}

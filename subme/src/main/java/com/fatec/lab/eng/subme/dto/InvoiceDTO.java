package com.fatec.lab.eng.subme.dto;

import java.util.Date;

public class InvoiceDTO extends RegisterDTO {
	private Date dueDate;
	private boolean wasPaid;
	private double value;
	private String description;
	private SubscriptionDTO subscription;

	public InvoiceDTO() {}

	public InvoiceDTO(Date dueDate, boolean wasPaid, double value, String description, SubscriptionDTO subscription) {
		this.dueDate = dueDate;
		this.wasPaid = wasPaid;
		this.value = value;
		this.description = description;
		this.subscription = subscription;
	}

	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public boolean isWasPaid() {
		return wasPaid;
	}
	public void setWasPaid(boolean wasPaid) {
		this.wasPaid = wasPaid;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public SubscriptionDTO getSubscription() {
		return subscription;
	}
	public void setSubscription(SubscriptionDTO subscription) {
		this.subscription = subscription;
	}
	
	
}

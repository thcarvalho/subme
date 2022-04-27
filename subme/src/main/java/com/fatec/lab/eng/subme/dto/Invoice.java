package com.fatec.lab.eng.subme.dto;

import java.util.Date;

public class Invoice extends Register{
	private Date dueDate;
	private boolean wasPaid;
	private double value;
	private String description;
	private Subscription subscription;
	
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
	public Subscription getSubscription() {
		return subscription;
	}
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	
	
}

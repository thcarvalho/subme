package com.fatec.lab.eng.subme.dto;

import com.fatec.lab.eng.subme.entities.InvoiceEntity;

import java.util.Date;

public class InvoiceDTO extends RegisterDTO {
	private Date dueDate;
	private boolean wasPaid;
	private double value;
	private String description;
	private Long idSubscription;

	public InvoiceDTO() {}

	public InvoiceDTO(Date dueDate, boolean wasPaid, double value, String description, Long subscription) {
		this.dueDate = dueDate;
		this.wasPaid = wasPaid;
		this.value = value;
		this.description = description;
		this.idSubscription = subscription;
	}

	public InvoiceDTO(InvoiceEntity invoiceEntity) {
		this.setId(invoiceEntity.getId());
		this.dueDate = invoiceEntity.getDueDate();
		this.wasPaid = invoiceEntity.isWasPaid();
		this.value = invoiceEntity.getValue();
		this.idSubscription = invoiceEntity.getSubscription();
		this.setCreatedAt(invoiceEntity.getCreatedAt());
		this.setUpdatedAt(invoiceEntity.getUpdatedAt());
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
	public Long getSubscription() {
		return idSubscription;
	}
	public void setSubscription(Long subscription) {
		this.idSubscription = subscription;
	}
	
	
}

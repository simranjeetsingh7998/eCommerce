package com.shopping.dto;

public class PurchaseResponse {
	private String orderTrackingNumber;

	public String getOrderTrackingNumber() {
		return orderTrackingNumber;
	}

	public void setOrderTrackingNumber(String orderTrackingNumber) {
		this.orderTrackingNumber = orderTrackingNumber;
	}

	@Override
	public String toString() {
		return "PurchseResponse [orderTrackingNumber=" + orderTrackingNumber + "]";
	}

}

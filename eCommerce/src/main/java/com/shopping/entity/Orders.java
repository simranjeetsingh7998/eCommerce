package com.shopping.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String orderTrackingNumber;
	private BigDecimal totalPrice;
	private Integer totalQuantity;
	private Integer customerId;
	private Integer billingAddressId;
	private Integer shippingAddressId;
	private String status;
	@CreationTimestamp
	private Date dateCreated;
	@UpdateTimestamp
	private Date lastCreated;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "shipping_address_id")
	private Address shippingAddress;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "billing_address_id")
	private Address billingAddress;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderTrackingNumber() {
		return orderTrackingNumber;
	}

	public void setOrderTrackingNumber(String orderTrackingNumber) {
		this.orderTrackingNumber = orderTrackingNumber;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Integer getBillingAddressId() {
		return billingAddressId;
	}

	public void setBillingAddressId(Integer billingAddressId) {
		this.billingAddressId = billingAddressId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getShippingAddressId() {
		return shippingAddressId;
	}

	public void setShippingAddressId(Integer shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastCreated() {
		return lastCreated;
	}

	public void setLastCreated(Date lastCreated) {
		this.lastCreated = lastCreated;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderTrackingNumber=" + orderTrackingNumber + ", totalPrice=" + totalPrice
				+ ", totalQuantity=" + totalQuantity + ", billingAddressId=" + billingAddressId + ", customerId="
				+ customerId + ", shippingAddressId=" + shippingAddressId + ", status=" + status + ", dateCreated="
				+ dateCreated + ", lastCreated=" + lastCreated + ", customer=" + customer + ", shippingAddress="
				+ shippingAddress + ", billingAddress=" + billingAddress + "]";
	}

}

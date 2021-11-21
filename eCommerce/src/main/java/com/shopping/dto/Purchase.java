package com.shopping.dto;

import java.util.Set;

import com.shopping.entity.Address;
import com.shopping.entity.Customer;
import com.shopping.entity.Orders;
import com.shopping.entity.OrderItem;

public class Purchase {
	private Customer customer;
	private Address shippingAddress;
	private Address billingAddress;
	private Orders order;
	private Set<OrderItem> orderItems;

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

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Purchase [customer=" + customer + ", shippingAddress=" + shippingAddress + ", billingAddress="
				+ billingAddress + ", order=" + order + ", orderItems=" + orderItems + "]";
	}

}

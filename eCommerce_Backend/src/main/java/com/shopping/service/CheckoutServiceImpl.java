package com.shopping.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.dto.Purchase;
import com.shopping.dto.PurchaseResponse;
import com.shopping.entity.Address;
import com.shopping.entity.Customer;
import com.shopping.entity.Orders;
import com.shopping.repository.AddressRepository;
import com.shopping.repository.CustomerRepository;
import com.shopping.repository.OrdersRepository;

@Service
@Transactional
public class CheckoutServiceImpl implements CheckoutService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private OrdersRepository ordersRepository;

	@Override
	public PurchaseResponse placeOrder(Purchase purchase) {
		String orderTrackingNumber = generateOrderTrackingNumber();

		Customer cust = purchase.getCustomer();
		Customer customer = new Customer();
		customer.setFirstName(cust.getFirstName());
		customer.setLastName(cust.getLastName());
		customer.setEmail(cust.getEmail());
		int customerId = customerRepository.save(customer).getId();

		Address sAdd = purchase.getShippingAddress();
		Address shippingAddress = new Address();
		shippingAddress.setCity(sAdd.getCity());
		shippingAddress.setCountry(sAdd.getCountry());
		shippingAddress.setState(sAdd.getState());
		shippingAddress.setStreet(sAdd.getStreet());
		shippingAddress.setZipCode(sAdd.getZipCode());
		int shippingAddressId = addressRepository.save(shippingAddress).getId();

		Address bAdd = purchase.getBillingAddress();
		Address billingAddress = new Address();
		billingAddress.setCity(bAdd.getCity());
		billingAddress.setCountry(bAdd.getCountry());
		billingAddress.setState(bAdd.getState());
		billingAddress.setStreet(bAdd.getStreet());
		billingAddress.setZipCode(bAdd.getZipCode());
		int billingAddressId = addressRepository.save(billingAddress).getId();

		Orders purchaseOrder = purchase.getOrder();
		Orders order = purchase.getOrder();
		order.setOrderTrackingNumber(orderTrackingNumber);
		order.setTotalPrice(purchaseOrder.getTotalPrice());
		order.setTotalQuantity(purchaseOrder.getTotalQuantity());
		order.setCustomerId(customerId);
		order.setShippingAddressId(shippingAddressId);
		order.setBillingAddressId(billingAddressId);
		order.setCustomer(customer);
		order.setBillingAddress(billingAddress);
		order.setShippingAddress(shippingAddress);
		ordersRepository.save(purchaseOrder);

		return new PurchaseResponse();
	}

	private String generateOrderTrackingNumber() {
		// generate a random UUID number
		return UUID.randomUUID().toString();
	}

}

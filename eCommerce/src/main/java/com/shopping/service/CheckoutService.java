package com.shopping.service;

import com.shopping.dto.Purchase;
import com.shopping.dto.PurchaseResponse;

public interface CheckoutService {
	PurchaseResponse placeOrder(Purchase purchase);
}
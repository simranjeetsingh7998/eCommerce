package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.dto.Purchase;
import com.shopping.dto.PurchaseResponse;
import com.shopping.service.CheckoutService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class CheckoutAPI {
	@Autowired
	private CheckoutService checkoutService;
	
	public ResponseEntity<PurchaseResponse> placeOrder(Purchase purchase) {
		PurchaseResponse res = checkoutService.placeOrder(purchase);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}

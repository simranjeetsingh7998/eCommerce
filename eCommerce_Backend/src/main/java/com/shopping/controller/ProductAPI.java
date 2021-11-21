package com.shopping.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.entity.Product;
import com.shopping.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class ProductAPI {
	@Autowired
	private ProductService productService;

	@GetMapping(value = "/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> productList = productService.getAllProducts();
		return new ResponseEntity<>(productList, HttpStatus.OK);
	}

	@GetMapping(value = "/products/productId/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(name = "id") Integer id) {
		Product product = productService.getProductById(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@GetMapping(value = "/category/{id}")
	public ResponseEntity<List<Product>> getProductByCategory(@PathVariable Integer id) {
		List<Product> productList = productService.getProductsByCategory(id);
		return new ResponseEntity<>(productList, HttpStatus.OK);
	}

	@GetMapping(value = "/products/{name}")
	public ResponseEntity<List<Product>> getProductByName(@PathVariable String name) {
		List<Product> productsWithSimilarName = productService.getProductByName(name);
		return new ResponseEntity<>(productsWithSimilarName, HttpStatus.OK);
	}
}

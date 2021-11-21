package com.shopping.service;

import java.util.List;

import com.shopping.entity.Product;

public interface ProductService {
	List<Product> getAllProducts();

	List<Product> getProductsByCategory(Integer id);

	List<Product> getProductByName(String name);

	Product getProductById(Integer id);
}

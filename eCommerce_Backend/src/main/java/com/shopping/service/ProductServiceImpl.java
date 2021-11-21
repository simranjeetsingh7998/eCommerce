package com.shopping.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shopping.entity.Product;
import com.shopping.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

//	private Pageable page = PageRequest.of(0, 10);
	
	@Override
	public List<Product> getAllProducts() {
//		return productRepository.findAll(page).getContent();
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		return productRepository.findById(id).get();
	}

	@Override
	public List<Product> getProductsByCategory(Integer id) {
		return productRepository.findByCategoryId(id);
	}

	@Override
	public List<Product> getProductByName(String name) {
		return productRepository.findByNameContaining(name);
	}

}

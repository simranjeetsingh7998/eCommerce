package com.shopping.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.entity.ProductCategory;
import com.shopping.repository.ProductCategoryRepository;

@Service
@Transactional
public class ProductCategoryServiceImpl implements ProductCategoryService {
	@Autowired
	private ProductCategoryRepository categoryRepository;

	@Override
	public List<ProductCategory> getAllCategories() {
		return categoryRepository.findAll();
	}
}

package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.entity.ProductCategory;
import com.shopping.service.ProductCategoryService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class ProductCategoryAPI {
	@Autowired
	private ProductCategoryService categoryService;

	@GetMapping(value = "/productCategory")
	public ResponseEntity<List<ProductCategory>> getAllCategories() {
		List<ProductCategory> categoryList = categoryService.getAllCategories();
		return new ResponseEntity<>(categoryList, HttpStatus.OK);
	}
}

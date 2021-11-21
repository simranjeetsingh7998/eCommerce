package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.entity.Country;
import com.shopping.service.CountryService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class CountryAPI {
	
	@Autowired
	private CountryService countryService;
	
	@GetMapping(value = "/countries")
	public ResponseEntity<List<Country>> getAllCountries() {
		List<Country> countriesList = countryService.getAllCountries();
		return new ResponseEntity<>(countriesList, HttpStatus.OK);
	}
}

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

import com.shopping.entity.State;
import com.shopping.service.StateService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class StateAPI {
	@Autowired
	private StateService stateService;
	
	@GetMapping(value = "/state/{name}")
	public ResponseEntity<List<State>> getStatesByCountry(@PathVariable String name) {
		List<State> stateList = stateService.getStatesByCountry(name);
		return new ResponseEntity<>(stateList, HttpStatus.OK);
	}
}

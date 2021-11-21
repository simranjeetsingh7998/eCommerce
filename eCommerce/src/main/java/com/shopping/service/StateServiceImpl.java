package com.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.entity.State;
import com.shopping.repository.StateRepository;

@Service
public class StateServiceImpl implements StateService {
	
	@Autowired
	private StateRepository stateRepository;

	@Override
	public List<State> getStatesByCountry(String name) {
		return stateRepository.findByCountryName(name);
	}

}

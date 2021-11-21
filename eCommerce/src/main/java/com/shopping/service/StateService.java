package com.shopping.service;

import java.util.List;

import com.shopping.entity.State;

public interface StateService {
	List<State> getStatesByCountry(String name);
}

package com.shopping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entity.State;

public interface StateRepository extends JpaRepository<State, Integer> {
	List<State> findByCountryName(String name);
}

package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}

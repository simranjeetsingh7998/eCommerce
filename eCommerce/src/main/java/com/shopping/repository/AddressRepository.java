package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}

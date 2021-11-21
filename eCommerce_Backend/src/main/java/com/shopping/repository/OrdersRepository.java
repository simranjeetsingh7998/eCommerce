package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}

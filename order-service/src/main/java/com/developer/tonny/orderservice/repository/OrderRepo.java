package com.developer.tonny.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developer.tonny.orderservice.entity.Order;

/**
 *
 * @author tonny
 */
public interface OrderRepo extends JpaRepository<Order, Integer> {

}

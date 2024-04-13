package com.shoppingapp.discoveryserver.orderservice.repository;


import com.shoppingapp.discoveryserver.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {
}

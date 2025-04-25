package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

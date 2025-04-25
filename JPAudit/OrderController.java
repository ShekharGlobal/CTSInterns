package com.cts.controller;

import com.cts.entity.Order;
import com.cts.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
   // http://localhost:2024/orders/save
    @PostMapping("/save")
    public Order create(@RequestBody Order order) {
        return orderService.createOrder(order);
    }
//http://localhost:2024/orders/all
    @GetMapping("/all")
    public List<Order> getAll() {
        return orderService.getAllOrders();
    }
}

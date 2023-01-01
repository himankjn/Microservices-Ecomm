package com.himankjn.orderservice.controller;

import com.himankjn.orderservice.model.Order;
import com.himankjn.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class orderController {
    private final OrderService orderService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody Order order){
        orderService.placeOrder(order);
        return "Order Placed Successfully!";
    }

}

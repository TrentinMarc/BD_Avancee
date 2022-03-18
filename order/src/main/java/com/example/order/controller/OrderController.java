package com.example.order.controller;

import com.example.order.models.Order;
import com.example.order.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepository;


    @PostMapping(value = "/order")
    public ResponseEntity<Order> createNewOrder(@RequestBody Order orderData)
    {
        Order order = orderRepository.save(new Order());
        if (order == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Couldn't create a new order");
        return new ResponseEntity<Order>(order, HttpStatus.CREATED);
    }

//    @GetMapping(value = "/order/{id}")
//    public Optional<Order> get(@PathVariable Long id) {
//        Optional<Order> orderInstance = orderRepository.findById(id);
//        if (!orderInstance.isPresent())
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Specified product doesn't exist");
//        return orderInstance;
//    }
}

package com.example.cart.controllers;

import com.example.cart.models.Cart;
import com.example.cart.models.CartItem;
import com.example.cart.repositories.CartItemRepository;
import com.example.cart.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class CartController {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @PostMapping(value = "/cart")
    public ResponseEntity<Cart> createNewCart()
    {
        Cart cart = cartRepository.save(new Cart());
        if (cart == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Couldn't create a new cart");
        return new ResponseEntity<Cart>(cart, HttpStatus.CREATED);
    }

    @GetMapping(value = "/cart/{id}")
    public Optional<Cart> getCart(@PathVariable Long id)
    {
        System.out.println("TBBBB");
        Optional<Cart> cart = cartRepository.findById(id);
        if(!cart.isPresent()){
            return null;
        }
        System.out.println(cart);
        return cart;
    }

    @PostMapping(value = "/cart/{id}")
    @Transactional
    public ResponseEntity<CartItem> addProductToCart(@PathVariable Long id, @RequestBody CartItem cartItem)
    {
        try{
            Cart cart = cartRepository.getOne(id);
            if (cart == null)
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't get cart");
            System.out.println(cart);
            cart.addProduct(cartItem);
            cartRepository.save(cart);
            return new ResponseEntity<CartItem>(cartItem, HttpStatus.CREATED);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }
}

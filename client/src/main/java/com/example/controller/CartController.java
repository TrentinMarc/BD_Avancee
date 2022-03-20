package com.example.controller;


import com.example.beans.CartBean;
import com.example.beans.CartItemBean;
import com.example.proxy.MsCartProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CartController {

    @Autowired
    private MsCartProxy msCartProxy;

    @RequestMapping(value = "/cart/{id}", method = RequestMethod.POST)
    public ResponseEntity<CartItemBean> addToCart(@PathVariable Long id, @RequestBody CartItemBean cartItem) {
        try{
            System.out.println(cartItem);
            return msCartProxy.addProductToCart(id, cartItem);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }


    }

    @PostMapping(value = "/cart")
    public ResponseEntity<CartBean> createNewCart(){
        try{
            ResponseEntity<CartBean> cart = msCartProxy.createNewCart();
            return cart;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping(value = "/cart/{id}")
    public Optional<CartBean> getCart(@PathVariable Long id){
        try{
            Optional<CartBean> cart = msCartProxy.getCart(id);
            return cart;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}

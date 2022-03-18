package com.example.controller;


import com.example.beans.CartBean;
import com.example.beans.CartItemBean;
import com.example.proxy.MsCartProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartController {

    @Autowired
    private MsCartProxy msCartProxy;

    @RequestMapping(value = "/cart/{id}")
    public void addToCart(@PathVariable Long id) {
        if(!msCartProxy.getCart(id).isPresent()) {
            msCartProxy.createNewCart();
        }


    }

}

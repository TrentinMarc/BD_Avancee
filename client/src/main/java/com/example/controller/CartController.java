package com.example.controller;


import com.example.proxy.MsCartProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {

    @Autowired
    private MsCartProxy msCartProxy;

    @RequestMapping()
    public void addToCart() {

    }

}

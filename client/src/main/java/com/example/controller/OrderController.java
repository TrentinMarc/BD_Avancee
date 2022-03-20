package com.example.controller;

import com.example.beans.CartBean;
import com.example.beans.OrderBean;
import com.example.proxy.MsOrderProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    MsOrderProxy msOrderProxy;

    @PostMapping(value = "/order")
    public ResponseEntity<String> createNewCart(){
        try{
            ResponseEntity<String> order = msOrderProxy.createNewOrder();
            return order;
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }
}

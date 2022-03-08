package com.example.controller;



import com.example.beans.ProductBean;
import com.example.proxy.MsProductProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private MsProductProxy msProductProxy;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        System.out.println("coucou");
        List<ProductBean> products = msProductProxy.list();
        model.addAttribute("products", products);
        return "index";
    }



}

package com.example.controller;



import com.example.beans.CartBean;
import com.example.beans.CartItemBean;
import com.example.beans.ProductBean;
import com.example.proxy.MsCartProxy;
import com.example.proxy.MsProductProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {

    @Autowired
    private MsProductProxy msProductProxy;

    @Autowired
    private MsCartProxy msCartProxy;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        List<ProductBean> products = msProductProxy.list();
        model.addAttribute("products", products);
        return "index";
    }

    @RequestMapping(value = "/product-detail/{id}", method = RequestMethod.GET)
    public String detail(Model model, @PathVariable Long id) {
        Optional<ProductBean> product = msProductProxy.get(id);
        model.addAttribute("product", product.get());
        return "detail";
    }
    @RequestMapping(value = "/mycart/{id}", method = RequestMethod.GET)
    public String cart(Model model, @PathVariable Long id) {
        Optional<CartBean> cart = msCartProxy.getCart(id);
        List<ProductBean> list = new ArrayList<>();
        float somme = 0;
        for(CartItemBean cartItemBean : cart.get().getProducts()){
            Optional<ProductBean> productBean = msProductProxy.get(cartItemBean.getProductId());
            list.add(productBean.get());
            somme += productBean.get().getPrice();
        }
        model.addAttribute("cartItems", list);
        model.addAttribute("somme", somme);
        return "cart";
    }



}

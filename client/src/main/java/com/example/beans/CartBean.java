package com.example.beans;


import java.util.List;

public class CartBean {

    private long id;
    private List<CartItemBean> products;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<CartItemBean> getProducts() {
        return products;
    }

    public void setProducts(List<CartItemBean> products) {
        this.products = products;
    }


}

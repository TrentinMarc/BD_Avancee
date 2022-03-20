package com.example.beans;

import java.util.List;

public class OrderBean {

    private long id;
    private CartBean cart;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CartBean getCart() {
        return cart;
    }

    public void setCart(CartBean cart) {
        this.cart = cart;
    }
}

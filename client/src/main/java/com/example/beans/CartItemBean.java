package com.example.beans;

public class CartItemBean {

    private long id;
    private long productId;
    private Integer quantity;

    public CartItemBean(long id, long productId) {
        this.id = id;
        this.productId = productId;
        this.quantity = 1;
    }


}

package com.example.order.models;


public class Order {

    private Long id;


    public Order(Long id) {
        this.id = id;
    }

    public Order(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                '}';
    }

}

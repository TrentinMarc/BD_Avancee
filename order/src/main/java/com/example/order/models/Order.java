package com.example.order.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    public Order(Long id, List<OrderItem> orderItems) {
        this.id = id;
        this.orderItems = orderItems;
    }

    public Order(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderItem> getProducts() {
        return orderItems;
    }

    public void setOrderProducts(List<OrderItem> order) {
        this.orderItems = order;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", order=" + orderItems +
                '}';
    }

    public double totalPrice() {
        double price = 0;

        for (int i = 0; i < orderItems.size(); i++) {
            price += orderItems.get(i).price;
        }

        return price;
    };
}

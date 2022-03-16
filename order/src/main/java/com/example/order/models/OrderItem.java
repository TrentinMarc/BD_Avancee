package com.example.order.models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    private Long id;
    private Long orderId;
    private Integer quantity;
    public double price;

    public OrderItem(Long id, Long orderId, Integer quantity, double price) {
        this.id = id;
        this.orderId = orderId;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

package models;

import com.example.cart.models.OrderItem;
import javax.persistence.*;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> orderProducts;

    public Order(Long id, List<OrderItem> orderProducts) {
        this.id = id;
        this.orderProducts = orderProducts;
    }

    public Order(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderItem> getProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderItem> order) {
        this.orderProducts = order;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", order=" + orderProducts +
                '}';
    }

    public double totalPrice() {
        double price = 0;

        for (int i = 0; i < orderProducts.size(); i++) {
            price += orderProducts.get(i).price;
        }

        return price;
    };
}

package com.example.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String illustration;
    private Double price;

    //CONSTRUCTOR

    public Product(String name, String description, String illustration, Double price) {
        this.name = name;
        this.description = description;
        this.illustration = illustration;
        this.price = price;
    }

    public Product() {

    }


    //GETTERS

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getIllustration() {
        return illustration;
    }

    public Double getPrice() {
        return price;
    }

    // SETTERS

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIllustration(String illustration) {
        this.illustration = illustration;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // TOSTRING


    @Override
    public String toString() {
        return "ProductApplication{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", illustration='" + illustration + '\'' +
                ", price=" + price +
                '}';
    }
}

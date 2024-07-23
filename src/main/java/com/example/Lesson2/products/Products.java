package com.example.Lesson2.products;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Products {
    @Id
    private Long id;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private Integer price;

    private String productName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}

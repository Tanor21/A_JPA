package com.norcorp.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 70)
    private String designation;
    private int price;
    private double quantity;
    @ManyToOne
    @JoinColumn(name = "ID_CAT")
    private Category category;

    public Product() {
    }

    public Product(String designation, int price, double quantity) {
        this.designation = designation;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product(String designation, int price, double quantity, Category category) {
        this.designation = designation;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }
}

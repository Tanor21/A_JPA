package com.norcorp.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;

@Entity
public class Category implements Serializable {
    @Id @GeneratedValue
    private Long id;
    private String categoryName;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private Collection<Product> products;

    public Category() {
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}

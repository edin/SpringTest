package com.example.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "products")
public class Product extends CustomEntity {

    @Column(name ="title")
    public String title;

    @Column(name ="description")
    public String description;

    @Column(name ="price")
    public BigDecimal price;

    @Column(name ="createdat")
    @CreatedDate
    public LocalDateTime createdAt;

    @Column(name ="updatedat")
    @LastModifiedDate
    public LocalDateTime updatedAt;

    @Column(name ="categoryid")
    public Long categoryId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryid", insertable = false,  updatable = false)
    public Category category;

    public void assign(Product model) {
        this.title = model.title;
        this.description = model.description;
        this.price = model.price;
        this.categoryId = model.categoryId;
        this.category = null;
    }

    @PrePersist
    public void onPrePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onPreUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
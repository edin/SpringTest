package com.example.models;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name ="Id")
    public Long id;

    @Column(name ="Title")
    public String title;

    @Column(name ="Description")
    public String description;

    @Column(name ="Price")
    public BigDecimal price;

    @Column(name ="CreatedAt")
    public Date createdAt;

    @Column(name ="UpdatedAt")
    public Date updatedAt;
}
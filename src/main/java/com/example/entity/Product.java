package com.example.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.entity.base.AuditEntity;

@Entity
@Table(name = "products")
public class Product extends AuditEntity {

    @Column(name ="title")
    public String title;

    @Column(name ="description")
    public String description;

    @Column(name ="price")
    public BigDecimal price;

    @Column(name ="categoryid")
    public Long categoryId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryid", insertable = false,  updatable = false)
    public Category category;
}
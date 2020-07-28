package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "Id")
    public Long id;

    @Column(name = "Title")
    public String title;

    @Column(name = "IsVisible")
    public boolean isVisible;

    @Column(name = "ImageUrl")
    public String imageUrl;
}
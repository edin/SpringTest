package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.entity.base.CustomEntity;

@Entity
@Table(name = "categories")
public class Category extends CustomEntity {

    @Column(name = "parentid", nullable = true)
    public Long parentId;

    @Column(name = "title")
    public String title;

    @Column(name = "isvisible")
    public boolean isVisible;

    @Column(name = "imageurl")
    public String imageUrl;
}
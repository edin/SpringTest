package com.example.repositories;

import java.util.List;

import com.example.entity.Category;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    @Override
    List<Category> findAll();

    List<Category> findAllByParentId(long parentId);
}
package com.example.models;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    // List<Customer> findByLastName(String lastName);
    // Customer findById(long id);

    @Override
    List<Category> findAll();
}
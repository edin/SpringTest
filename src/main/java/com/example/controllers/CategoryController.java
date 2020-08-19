package com.example.controllers;

import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;

import com.example.entity.*;
import com.example.repositories.*;

@RestController()
@RequestMapping("categories")
@Api(tags={"Category"})
public class CategoryController {

	@Autowired
	private CategoryRepository repository;

	private Category findEntityById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
	}

	@GetMapping("")
	public List<Category> query() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Category getById(@PathVariable final long id) {
		return findEntityById(id);
	}

	@PostMapping("")
	public Category create(@RequestBody final Category model) {
	  return repository.save(model);
	}

	@PutMapping("/{id}")
	public Category update(@RequestBody final Category model, @PathVariable final Long id)
	{
		Category entity = findEntityById(id);
		entity.assign(model);
		return repository.save(entity);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable final Long id) {
		Category entity = findEntityById(id);
		repository.deleteById(entity.id);
	}
}
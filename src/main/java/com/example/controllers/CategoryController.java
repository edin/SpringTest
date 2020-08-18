package com.example.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.List;
import com.example.models.*;

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
	Category create(@RequestBody final Category model) {
	  return repository.save(model);
	}

	@PutMapping("/{id}")
	Category update(@RequestBody final Category model, @PathVariable final Long id)
	{
		Category entity = findEntityById(id);
		entity.assign(model);
		return repository.save(entity);
	}

	@DeleteMapping("/{id}")
	void delete(@PathVariable final Long id) {
		Category entity = findEntityById(id);
		repository.deleteById(entity.id);
	}
}
package com.example.controllers;

import com.example.messages.CategoryMessages.CategoryRequest;
import com.example.messages.CategoryMessages.CategoryResponse;
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

	@GetMapping("nodes/{id}")
	public List<Category> queryChildNodes(@PathVariable final long id) {
		return repository.findAllByParentId(id);
	}

	@GetMapping("/{id}")
	public CategoryResponse getById(@PathVariable final long id) {
		return CategoryResponse.from(findEntityById(id));
	}

	@PostMapping("")
	public CategoryResponse create(@RequestBody final CategoryRequest model) {
	  return CategoryResponse.from(repository.save(model.toEntity()));
	}

	@PutMapping("/{id}")
	public CategoryResponse update(@RequestBody final CategoryRequest model, @PathVariable final Long id)
	{
		Category entity = findEntityById(id);
		return CategoryResponse.from(repository.save(model.assignTo(entity)));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable final Long id) {
		Category entity = findEntityById(id);
		repository.deleteById(entity.id);
	}
}
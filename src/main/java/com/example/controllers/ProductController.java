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


import java.util.List;
import java.util.Optional;

import com.example.models.*;

@RestController()
@RequestMapping("products")
@Api(tags={"Product"} )
public class ProductController {

	@Autowired
	private ProductRepository repository;

	@GetMapping("")
	public List<Product> query() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Product> getById(@PathVariable final long id) {
		return repository.findById(id);
	}

	@PostMapping("")
	Product create(@RequestBody final Product model) {
	  return repository.save(model);
	}

	@PutMapping("/{id}")
	Product update(@RequestBody final Product model, @PathVariable final Long id) {

		return repository.findById(id)
			.map(employee -> {
				//   employee.setName(newEmployee.getName());
				//   employee.setRole(newEmployee.getRole());
				return repository.save(model);
			})
			.orElseGet(() -> {
				//newEmployee.setId(id);
				return repository.save(model);
			});
	}

	@DeleteMapping("/{id}")
	void delete(@PathVariable final Long id) {
		repository.deleteById(id);
	}
}
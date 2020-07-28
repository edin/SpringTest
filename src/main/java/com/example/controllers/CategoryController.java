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
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.List;
import java.util.Optional;

import com.example.models.*;

@RestController()
@RequestMapping("categories")
@Api(tags={"Category"})
public class CategoryController {

	@Autowired
	private CategoryRepository repository;

	@GetMapping("")
	public List<Category> query() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Category> getById(@PathVariable final long id) {
		return repository.findById(id);
	}

	@PostMapping("")
	Category create(@RequestBody final Category model) {
	  return repository.save(model);
	}

	@PutMapping("/{id}")
	Category update(@RequestBody final Category model, @PathVariable final Long id) {

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

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(String message) throws Exception {
	  Thread.sleep(1000);
	  return new Greeting(1, "Hello, " + message + "!");
	}
}
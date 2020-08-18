package com.example.controllers;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import com.example.messages.PagedResult;
import com.example.messages.ProductMessages.ProductRequest;
import com.example.messages.ProductMessages.ProductResponse;
import com.example.models.*;

@RestController()
@RequestMapping("products")
@Api(tags={"Product"} )
public class ProductController {

	@Autowired
	private ProductRepository repository;

	private Product findEntityById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
	}

	@GetMapping("")
	public PagedResult<ProductResponse> query(Pageable pagable) {
		return PagedResult.from(repository.findAll(pagable).map(p -> ProductResponse.from(p)));
	}

	@GetMapping("/{id}")
	public ProductResponse getById(@PathVariable final long id) {
		return ProductResponse.from(findEntityById(id));
	}

	@PostMapping("")
	ProductResponse create(@RequestBody final ProductRequest model) {
		Product result = repository.save(model.asProduct());
		return ProductResponse.from(result);
	}

	@PutMapping("/{id}")
	ProductResponse update(@RequestBody final ProductRequest model, @PathVariable final Long id) {
		Product entity = findEntityById(id);
		repository.save(model.assignTo(entity));
		return ProductResponse.from(findEntityById(id));
	}

	@DeleteMapping("/{id}")
	void delete(@PathVariable final Long id) {
		Product entity = findEntityById(id);
		repository.deleteById(entity.id);
	}
}
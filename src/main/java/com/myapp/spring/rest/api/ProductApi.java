package com.myapp.spring.rest.api;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Product;
import com.myapp.spring.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductApi {

	@Autowired
	private ProductRepository repository;

	@GetMapping
	public List<Product> getAll() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Product findById(@PathVariable("id") Integer productid) {
		return repository.findById(productid);
	}

	@PostMapping
	public Product saveNewProduct(@RequestBody Product product) {
		return repository.saveProduct(product);
	}

	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable("id") Integer productid, @RequestBody Product product) {
		Product existingProduct = repository.findById(productid);
		BeanUtils.copyProperties(product, existingProduct);
		return repository.saveProduct(product);
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable("id") Integer productid) {
		// Product existingProduct=repository.findById(productid);
		repository.delete(productid);
	}
}

package com.myapp.spring.repository;
import java.util.List;

import com.myapp.spring.model.Product;
public interface ProductRepository {

	Product saveProduct(Product product);
	Product updateProduct(Product product);
	List<Product> findAll();

	void delete(Integer productId);
	
	Product findById(Integer id);
}

package com.hc.product.dao;

import java.util.List;

import com.hc.product.model.Product;

public interface ProductDAO {

	Product findProductById(Long id);

	List<Product> findAllProducts();
	
	List<Product> findAllNonSoftDeletedProducts();

	void saveProduct(Product product);

	void deleteProduct(Long id);

}

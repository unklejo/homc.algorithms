package com.hc.product.service;

import java.util.List;

import com.hc.product.model.Product;

public interface ProductService {
	
    void saveProduct(Product product);
     
    void updateProduct(Product product);
     
    void deleteProductById(Long id);
 
    List<Product> findAllProducts(); 
     
    Product findProductById(Long id);
 
}


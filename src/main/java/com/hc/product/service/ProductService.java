package com.hc.product.service;

import java.util.List;

import com.hc.product.model.Product;

public interface ProductService {
	
    void saveNewProduct(Product product);

    void saveProduct(Product product);
     
    void updateProduct(Product product);
     
    void physicalDeleteProductById(Long id);
 
    void softDeleteProductById(Long id);

    List<Product> findAllProducts();
    
    List<Product> findAllNonSoftDeletedProducts();
     
    Product findProductById(Long id);
 
}


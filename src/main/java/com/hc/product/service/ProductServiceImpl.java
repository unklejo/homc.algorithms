package com.hc.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hc.product.dao.ProductDAO;
import com.hc.product.model.Product;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
    private ProductDAO dao;

	@Override
	public void saveProduct(Product product) {
		 dao.saveProduct(product);
	}

	@Override
	public void updateProduct(Product product) {
		Product entity = dao.findProductById(product.getId());
        if(entity!=null){
            entity.setName(product.getName());
            entity.setPrice(product.getPrice());
            entity.setIsDeleted("N");
        }
	}

	@Override
	public void physicalDeleteProductById(Long id) {
		dao.deleteProduct(id);
	}

	@Override
	public void softDeleteProductById(Long id) {
		Product product = dao.findProductById(id);
        if(product != null) {
            product.setIsDeleted("Y");
        }
        saveProduct(product);
	}

	
	@Override
	public List<Product> findAllProducts() {
		return dao.findAllProducts();
	}
	
	@Override
	public List<Product> findAllNonSoftDeletedProducts() {
		return dao.findAllNonSoftDeletedProducts();
	}
	

	@Override
	public Product findProductById(Long id) {
		return dao.findProductById(id);
	}
	
}

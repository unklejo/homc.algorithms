package com.hc.product.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.hc.product.model.Product;

@Repository("productDao")
public class ProductDAOImpl extends AbstractDAO<Long, Product> implements
		ProductDAO {
	@Override
	public Product findProductById(Long id) {
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllProducts() {
		Criteria criteria = createEntityCriteria();
		return (List<Product>) criteria.list();
	}

	@Override
	public void saveProduct(Product product) {
		persist(product);
	}

	@Override
	public void deleteProduct(Long id) {
		Query query = getSession().createSQLQuery(
				"delete from Product where id = :id");
		query.setLong("id", id);
		query.executeUpdate();
	}

}

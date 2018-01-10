package com.hc.product.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.hc.product.model.Order;

@Repository("orderDao")
public class OrderDAOImpl extends AbstractDAO<Long, Order> implements
		OrderDAO {
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findAllOrders() {
		Criteria criteria = createEntityCriteria();
		return (List<Order>) criteria.list();
	}

}

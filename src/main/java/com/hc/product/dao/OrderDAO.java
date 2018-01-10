package com.hc.product.dao;

import java.util.List;

import com.hc.product.model.Order;

public interface OrderDAO {

	List<Order> findAllOrders();
	
//	Order findOrderById(Long id);
//
//	void saveOrder(Order order);
//
//	void deleteOrder(Long id);

}

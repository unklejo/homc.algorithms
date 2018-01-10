package com.hc.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hc.product.dao.OrderDAO;
import com.hc.product.model.Order;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
    private OrderDAO dao;

	@Override
	public List<Order> findAllOrders() {
		return dao.findAllOrders();
	}
	
}

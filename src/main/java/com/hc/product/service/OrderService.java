package com.hc.product.service;

import java.util.List;

import com.hc.product.model.Order;

public interface OrderService {
	
    List<Order> findAllOrders();
    
}


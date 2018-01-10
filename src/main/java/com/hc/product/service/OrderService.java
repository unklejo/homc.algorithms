package com.hc.product.service;

import java.util.List;

import com.hc.product.model.Order;
import com.hc.product.model.OrderDetail;

public interface OrderService {
	
    List<Order> findAllOrders();
    
    List<OrderDetail> findAllDetailOrdersByInvoiceNumber(Integer invoiceNo);
    
}


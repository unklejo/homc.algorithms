package com.hc.product.dao;

import java.util.List;

import com.hc.product.model.Order;
import com.hc.product.model.OrderDetail;

public interface OrderDAO {

	List<Order> findAllOrders();
	
	List<OrderDetail> findAllOrderDetailByInvoiceNo(Integer invoiceNo);
	
//	Order findOrderById(Long id);
//
//	void saveOrder(Order order);
//
//	void deleteOrder(Long id);

}

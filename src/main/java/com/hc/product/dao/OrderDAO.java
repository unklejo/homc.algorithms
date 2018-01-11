package com.hc.product.dao;

import java.util.List;

import com.hc.product.domain.OrderProductSum;
import com.hc.product.model.Order;
import com.hc.product.model.OrderProduct;

public interface OrderDAO {

	List<Order> findAllOrders();
	
	List<OrderProduct> findAllOrderProductByInvoiceNo(Integer invoiceNo);
	
	// OrderProductSum inquireOrderProductByLargestQuantity();

	Object[] inquireOrderProductByLargestQuantity();

//	Order findOrderById(Long id);
//
//	void saveOrder(Order order);
//
//	void deleteOrder(Long id);

}

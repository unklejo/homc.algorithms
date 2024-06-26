package com.hc.product.service;

import java.util.List;

import com.hc.product.domain.OrderDetail;
import com.hc.product.domain.OrderProductSum;
import com.hc.product.model.Order;
import com.hc.product.model.OrderProduct;

public interface OrderService {

	List<Order> findAllOrders();

	List<OrderProduct> findAllDetailOrdersByInvoiceNumber(Integer invoiceNo);

	OrderDetail findOrderDetailByInvoiceNumber(Integer invoiceNo);
	
	OrderProductSum inquireOrderProductByLargestQuantity();

}

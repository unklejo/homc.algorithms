package com.hc.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hc.product.dao.OrderDAO;
import com.hc.product.domain.Item;
import com.hc.product.domain.OrderDetail;
import com.hc.product.domain.OrderProductSum;
import com.hc.product.model.Order;
import com.hc.product.model.OrderProduct;
import com.hc.product.model.Product;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO dao;

	@Override
	public List<Order> findAllOrders() {
		return dao.findAllOrders();
	}

	 @Override
	 public List<OrderProduct> findAllDetailOrdersByInvoiceNumber(Integer
	 invoiceNo) {
	 return dao.findAllOrderProductByInvoiceNo(invoiceNo);
	 }

	@Override
	public OrderDetail findOrderDetailByInvoiceNumber(
			Integer invoiceNo) {
		List<OrderProduct> orderProductList = dao
				.findAllOrderProductByInvoiceNo(invoiceNo);
		if (orderProductList != null && orderProductList.size() > 0) {
			List<Item> itemList = new ArrayList<Item>();
			for (OrderProduct orderProduct : orderProductList) {
				Item item = new Item();
				item.setProductId(orderProduct.getProduct().getId());
				item.setName(orderProduct.getProduct().getName());
				item.setPrice(orderProduct.getProduct().getPrice());
				item.setQuantity(orderProduct.getQuantity());
				itemList.add(item);
			}
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrderId(orderProductList.get(0).getId());
			orderDetail.setInvoiceNo(orderProductList.get(0).getOrder().getInvoiceNo());
			orderDetail.setCustomerName(orderProductList.get(0).getOrder().getCustomerName());
			orderDetail.setRegTime(orderProductList.get(0).getOrder().getCreateOrder());
			orderDetail.setItemList(itemList);
			return orderDetail;
		}
		return null;
	}
	
	public OrderProductSum inquireOrderProductByLargestQuantity() {
		Object[] objArr = dao.inquireOrderProductByLargestQuantity();
		if (objArr != null) {
			OrderProductSum ops = new OrderProductSum();
			ops.setProductId(String.valueOf(objArr[0]));
			ops.setSumQty(String.valueOf(objArr[1]));
			return ops;
		}
		return null;
//		return dao.inquireOrderProductByLargestQuantity();
	}
}

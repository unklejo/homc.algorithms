package com.hc.product.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hc.product.model.Order;
import com.hc.product.model.OrderDetail;

@Repository("orderDao")
public class OrderDAOImpl extends AbstractDAO<Long, Order> implements
		OrderDAO {
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findAllOrders() {
		Criteria criteria = createEntityCriteria();
		return (List<Order>) criteria.list();
	}
	
	@Override
	public List<OrderDetail> findAllOrderDetailByInvoiceNo(Integer invoiceNo) {
		Query query = getSession().createQuery(
				"select od"
				+ " from OrderDetail od"
				+ " join od.order o"
				+ " where o.invoiceNo = :invoiceNo");
		query.setInteger("invoiceNo", invoiceNo);
		return (List<OrderDetail>) query.list();
	}

}

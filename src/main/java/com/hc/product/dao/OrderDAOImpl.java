package com.hc.product.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hc.product.model.Order;
import com.hc.product.model.OrderProduct;

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
	public List<OrderProduct> findAllOrderProductByInvoiceNo(Integer invoiceNo) {
		Query query = getSession().createQuery(
				"select op"
				+ " from OrderProduct op"
				+ " join op.order o"
				+ " where o.invoiceNo = :invoiceNo");
		query.setInteger("invoiceNo", invoiceNo);
		return (List<OrderProduct>) query.list();
	}

}

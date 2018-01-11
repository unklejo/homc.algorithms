package com.hc.product.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hc.product.domain.OrderProductSum;
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
	
//	@Override
//	public OrderProductSum inquireOrderProductByLargestQuantity() {
//		Query query = getSession().createQuery(
//				"select p, sum(o.quantity) as sumQty "
//				+ " from OrderProduct o"
//				+ " join o.product p"
//				+ " group by product_id"
//				+ " order by sumQty desc");
//		query.setMaxResults(1);
//		return (OrderProductSum) query.uniqueResult();
//	}

	@Override
	public Object[] inquireOrderProductByLargestQuantity() {
		Query query = getSession().createSQLQuery(
				"select product_id,sum(quantity) as sum"
				+ " from product_order_detail op"
				+ " group by product_id"
				+ " order by sum desc");
		query.setMaxResults(1);
		return (Object[]) query.uniqueResult();
	}

}

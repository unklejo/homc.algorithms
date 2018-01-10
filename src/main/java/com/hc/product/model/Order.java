package com.hc.product.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private long id;

	@Column(name = "customer_name", length = 225, nullable = false)
	private String customerName;

	@Column(name = "invoice_no", nullable = false)
	private long invoiceNo;

	@Column(name = "create_order", nullable = false)
	private Date createOrder;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(long invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Date getCreateOrder() {
		return createOrder;
	}

	public void setCreateOrder(Date createOrder) {
		this.createOrder = createOrder;
	}

//	// additional
//	@OneToMany(mappedBy = "order")
//	private List<OrderDetail> orderDetailList;
//
//	public List<OrderDetail> getOrderDetailList() {
//		return orderDetailList;
//	}
//
//	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
//		this.orderDetailList = orderDetailList;
//	}

}

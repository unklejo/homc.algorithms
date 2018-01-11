package com.hc.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.hc.product.domain.OrderDetail;
import com.hc.product.domain.OrderProductSum;
import com.hc.product.model.Order;
import com.hc.product.model.OrderProduct;
import com.hc.product.model.Product;
import com.hc.product.service.OrderService;
import com.hc.product.service.ProductService;

@Controller
@RequestMapping("/")
@ComponentScan("com.hc.product")
public class AppController {

	@Autowired
	ProductService productService;

	@Autowired
	OrderService orderService;

	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = { "/", "/menu" }, method = RequestMethod.GET)
	public String loadMainPage(ModelMap model) {
		return "main";
	}

	@RequestMapping(value = { "/list-product" }, method = RequestMethod.GET)
	public String listProducts(ModelMap model) {
		List<Product> products = productService.findAllNonSoftDeletedProducts();
		model.addAttribute("products", products);
		return "allproducts";
	}

	@RequestMapping(value = { "/new-product" }, method = RequestMethod.GET)
	public String newProduct(ModelMap model) {
		Product product = new Product();
		product.setIsDeleted("N");
		model.addAttribute("product", product);
		model.addAttribute("edit", false);
		return "productRegistration";
	}

	@RequestMapping(value = { "/new-product" }, method = RequestMethod.POST)
	public String saveProduct(@Valid Product product, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "productRegistration";
		}

		productService.saveNewProduct(product);

		model.addAttribute("success", "Product " + product.getName()
				+ " inserted successfully");
		return "success";
	}

	@RequestMapping(value = { "/edit-{id}-product" }, method = RequestMethod.GET)
	public String editProduct(@PathVariable Long id, ModelMap model) {
		Product product = productService.findProductById(id);
		model.addAttribute("product", product);
		model.addAttribute("edit", true);
		return "productRegistration";
	}

	@RequestMapping(value = { "/edit-{id}-product" }, method = RequestMethod.POST)
	public String updateProduct(@Valid Product product, BindingResult result,
			ModelMap model, @PathVariable Long id) {
		if (result.hasErrors()) {
			return "productRegistration";
		}
		productService.updateProduct(product);

		model.addAttribute("success", "Product " + product.getName()
				+ " updated successfully");
		return "success";
	}

	// physical delete
	@RequestMapping(value = { "/delete-{id}-product" }, method = RequestMethod.GET)
	public String deleteProduct(@PathVariable Long id) {
		productService.physicalDeleteProductById(id);
		return "redirect:/list-product";
	}

	// soft delete
	@RequestMapping(value = { "/soft-delete-{id}-product" }, method = RequestMethod.GET)
	public String softDeleteProduct(@PathVariable Long id) {
		productService.softDeleteProductById(id);
		return "redirect:/list-product";
	}
	
	//---ORDER UI---
	@RequestMapping(value = { "/list-order" }, method = RequestMethod.GET)
	public String listOrders(ModelMap model) {
		List<Order> orders = orderService.findAllOrders();
		model.addAttribute("orders", orders);
		return "allorders";
	}
	
	//---ORDER DETAIL UI---
	@RequestMapping(value = { "/detail-{invoiceNo}-orderDetail" }, method = RequestMethod.GET)
	public String detailOrderByOrderId(ModelMap model, @PathVariable Integer invoiceNo) {
		OrderDetail orderDetail = orderService.findOrderDetailByInvoiceNumber(invoiceNo);
		model.addAttribute("orderDetail", orderDetail);
		return "orderDetail";
	}

	//---ORDER DETAIL UI---
	@RequestMapping(value = { "/most-bought-product" }, method = RequestMethod.GET)
	public String mostBoughtProduct(ModelMap model) {
		OrderProductSum orderProductSum = orderService.inquireOrderProductByLargestQuantity();
		model.addAttribute("orderProductSum", orderProductSum);
		return "orderDetail";
	}

	@ResponseBody
	@RequestMapping(value = { "/mostJSON" }, method = RequestMethod.GET)
	public String mostBoughtProductJSON() {
		OrderProductSum orderProductSum = orderService.inquireOrderProductByLargestQuantity();
		return new Gson().toJson(orderProductSum);		
	}
	
	//---ORDER DETAIL API---
//	@RequestMapping(value = { "/list-order-detail" }, method = RequestMethod.GET)
//	public String listOrderDetails(ModelMap model) {
//		List<Order> orders = orderService.findAllOrders();
//		model.addAttribute("orders", orders);
//		return "allorders";
//	}
	
	//---ORDER API---
	@ResponseBody
	@RequestMapping(value = { "/listOrderJSON" }, method = RequestMethod.GET)
	public String listOrdersJSON() {
		List<Order> orders = orderService.findAllOrders();
		return new Gson().toJson(orders);		
	}

	//---ORDER DETAIL API---
	@ResponseBody
	@RequestMapping(value = { "/listOrderProductJSON" }, method = RequestMethod.GET)
	public String listOrderDetailsJSON(@RequestParam Integer invoiceNo) {
		List<OrderProduct> listOrderProduct = orderService.findAllDetailOrdersByInvoiceNumber(invoiceNo);
		return new Gson().toJson(listOrderProduct);	
	}
	
	@ResponseBody
	@RequestMapping(value = { "/orderDetailJSON" }, method = RequestMethod.GET)
	public OrderDetail orderDetailsJSON(@RequestParam Integer invoiceNo) {
		return orderService.findOrderDetailByInvoiceNumber(invoiceNo);
	}
}

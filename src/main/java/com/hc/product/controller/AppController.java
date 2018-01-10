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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.hc.product.model.Order;
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

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listProducts(ModelMap model) {
		List<Product> products = productService.findAllNonSoftDeletedProducts();
		model.addAttribute("products", products);
		return "allproducts";
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newProduct(ModelMap model) {
		Product product = new Product();
		product.setIsDeleted("N");
		model.addAttribute("product", product);
		model.addAttribute("edit", false);
		return "registration";
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveProduct(@Valid Product product, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		product.setIsDeleted("N");
		productService.saveProduct(product);

		model.addAttribute("success", "Product " + product.getName()
				+ " inserted successfully");
		return "success";
	}

	@RequestMapping(value = { "/edit-{id}-product" }, method = RequestMethod.GET)
	public String editProduct(@PathVariable Long id, ModelMap model) {
		Product product = productService.findProductById(id);
		model.addAttribute("product", product);
		model.addAttribute("edit", true);
		return "registration";
	}

	@RequestMapping(value = { "/edit-{id}-product" }, method = RequestMethod.POST)
	public String updateProduct(@Valid Product product, BindingResult result,
			ModelMap model, @PathVariable Long id) {
		if (result.hasErrors()) {
			return "registration";
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
		return "redirect:/list";
	}

	// soft delete
	@RequestMapping(value = { "/soft-delete-{id}-product" }, method = RequestMethod.GET)
	public String softDeleteProduct(@PathVariable Long id) {
		productService.softDeleteProductById(id);
		return "redirect:/list";
	}
	
	
	//---ORDER---
	@RequestMapping(value = { "/listOrder" }, method = RequestMethod.GET)
	public String listOrders(ModelMap model) {
		List<Order> orders = orderService.findAllOrders();
		model.addAttribute("orders", orders);
		return "allorders";
	}
	
	@ResponseBody
	@RequestMapping(value = { "/listOrderJSON" }, method = RequestMethod.GET)
	public String listOrdersJSON() {
		List<Order> orders = orderService.findAllOrders();
		return new Gson().toJson(orders);		
	}

//	//---ORDER DETAIL---
//	@RequestMapping(value = { "/listOrderDetail" }, method = RequestMethod.GET)
//	public String listOrderDetails(ModelMap model) {
//		List<Order> orders = orderService.findAllOrders();
//		model.addAttribute("orders", orders);
//		return "allorders";
//	}
//	
//	@ResponseBody
//	@RequestMapping(value = { "/listOrderDetailJSON" }, method = RequestMethod.GET)
//	public String listOrdersJSON() {
//		List<Order> orders = orderService.findAllOrders();
//		return new Gson().toJson(orders);		
//	}
	
}

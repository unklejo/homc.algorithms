package com.hc.product.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hc.product.model.Product;
import com.hc.product.service.ProductService;


@Controller
@RequestMapping("/")
@ComponentScan("com.hc.product") 
public class AppController {
	
    @Autowired
    ProductService service;
     
    @Autowired
    MessageSource messageSource;
 
    /*
     * This method will list all existing products.
     */
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listProducts(ModelMap model) {
 
        List<Product> products = service.findAllProducts();
        model.addAttribute("products", products);
        return "allproducts";
    }
 
    /*
     * This method will provide the medium to add a new product.
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newProduct(ModelMap model) {
        Product product = new Product();
        product.setIsDeleted("F");
        model.addAttribute("product", product);
        model.addAttribute("edit", false);
        return "registration";
    }
 
    /*
     * This method will be called on form submission, handling POST request for
     * saving product in database. It also validates the user input
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveProduct(@Valid Product product, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "registration";
        }
 
        /*
         * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation 
         * and applying it on field [ssn] of Model class [Product].
         * 
         * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
         * framework as well while still using internationalized messages.
         * 
         */
//        if(!service.isProductSsnUnique(product.getId(), product.getSsn())){
//            FieldError ssnError =new FieldError("product","ssn",messageSource.getMessage("non.unique.ssn", new String[]{product.getSsn()}, Locale.getDefault()));
//            result.addError(ssnError);
//            return "registration";
//        }
         
        product.setIsDeleted("F");
        service.saveProduct(product);
 
        model.addAttribute("success", "Product " + product.getName() + " inserted successfully");
        return "success";
    }
 
 
    /*
     * This method will provide the medium to update an existing product.
     */
    @RequestMapping(value = { "/edit-{id}-product" }, method = RequestMethod.GET)
    public String editProduct(@PathVariable Long id, ModelMap model) {
        Product product = service.findProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("edit", true);
        return "registration";
    }
     
    /*
     * This method will be called on form submission, handling POST request for
     * updating product in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-{id}-product" }, method = RequestMethod.POST)
    public String updateProduct(@Valid Product product, BindingResult result,
            ModelMap model, @PathVariable Long id) {
 
        if (result.hasErrors()) {
            return "registration";
        }
 
//        if(!service.isProductSsnUnique(product.getId(), product.getSsn())){
//            FieldError ssnError =new FieldError("product","ssn",messageSource.getMessage("non.unique.ssn", new String[]{product.getSsn()}, Locale.getDefault()));
//            result.addError(ssnError);
//            return "registration";
//        }
 
        service.updateProduct(product);
 
        model.addAttribute("success", "Product " + product.getName()  + " updated successfully");
        return "success";
    }
 
    
    /*
     * This method will delete an product by it's SSN value.
     */
    @RequestMapping(value = { "/delete-{id}-product" }, method = RequestMethod.GET)
    public String deleteProduct(@PathVariable Long id) {
        service.deleteProductById(id);
        return "redirect:/list";
    }
 

}


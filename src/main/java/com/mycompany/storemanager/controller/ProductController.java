package com.mycompany.storemanager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import com.mycompany.storemanager.entity.Product;
import com.mycompany.storemanager.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	// inject product service
	@Autowired
	private ProductService productService;
	
	@GetMapping("/list")
	public String getAllProducts(Model theModel) {
		// get all products
		List<Product> productList = productService.getAllProducts();
		// add to this as attribute to the model
		theModel.addAttribute("products",productList);
		return "all-products";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model theModel) {
		// create a model and bind
		Product newProduct = new Product();
		// add to this as attribute to the model
		theModel.addAttribute("product",newProduct);
		return "add-product-form";
	}

	@PostMapping("/saveProduct")
	public String saveProduct(@Valid @ModelAttribute("product") Product theProduct,
							BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("error");
			return "add-product-form"; 
		}else {
			System.out.println("no error");
			// save employee
			productService.save(theProduct);
			// redirect to list
			return "redirect:/products/list";
		}
		
		
	}
	
}

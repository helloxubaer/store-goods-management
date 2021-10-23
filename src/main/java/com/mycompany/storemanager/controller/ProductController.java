package com.mycompany.storemanager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.storemanager.entity.Product;
import com.mycompany.storemanager.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	// initbinder
	// trim leading and trailing spaces
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	
	// inject product service
	@Autowired
	private ProductService productService;
	
	@GetMapping("/list")
	public String getAllProducts(Model theModel) {
		// get all products
		List<Product> productList = productService.getAllProducts();
		// add to this as attribute to the model
		theModel.addAttribute("products",productList);
		return "/products/all-products";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model theModel) {
		// create a model and bind
		Product newProduct = new Product();
		// add to this as attribute to the model
		theModel.addAttribute("product",newProduct);
		return "/products/add-product-form";
	}

	@PostMapping("/saveProduct")
	public String saveProduct(@Valid @ModelAttribute("product") Product theProduct,
							BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("error");
			return "products/add-product-form"; 
		}else {
			System.out.println("no error");
			// save employee
			productService.save(theProduct);
			// redirect to list
			return "redirect:/products/list";
		}
	}
	
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("productId") int theId,
						Model theModel) {
		// get the product
		Product theProduct = productService.getProductById(theId);
		// add to the model to prepopulate the add-product form
		theModel.addAttribute("product",theProduct);
		return "/products/add-product-form";
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("productId") int theId) {
		productService.deleteProduct(theId);
		return "redirect:/products/list";
	}
	
}

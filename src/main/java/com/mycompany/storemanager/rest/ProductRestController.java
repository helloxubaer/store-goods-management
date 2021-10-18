package com.mycompany.storemanager.rest;

import java.util.List;

import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.storemanager.entity.Product;
import com.mycompany.storemanager.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductRestController {

	// inject product service
	@Autowired
	private ProductService productService;
	
	// expose an endpoint: "/products"
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		List<Product> productsList = productService.getAllProducts();
		return productsList;
	}
	@GetMapping("/products/{productId}")
	public Product getProductById(@PathVariable("productId") int productId){
		Product product = productService.getProductById(productId);
		//to-do if null, instead of shown null return exception
		if (product == null) {
			throw new ProductNotFoundInDbException("Studen id not found in DB: "
					+ productId);
		}
		
		return product;
	}
	
	// to-do add delete,update,exception handle
	// add mapping POST /products
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product theProduct) {
		
		theProduct.setId(0); // new product, handle if user put id by mistake
		productService.save(theProduct);
		return theProduct;
		
	}
	// add mapping PUT /products
	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product theProduct) {
		productService.save(theProduct);
		return theProduct;
	}
	// add mapping DELETE /products
	@DeleteMapping("/products/{productId}")
	public String deleteProduct(@PathVariable("productId") int theId) {
		productService.deleteProduct(theId);
		return "Deleted product id: " + theId;
	}
	
}

















package com.mycompany.storemanager.service;

import java.util.List;

import com.mycompany.storemanager.entity.Product;

public interface ProductService {

	public List<Product> getAllProducts();
	
	public Product getProductById(int theId);
	
	public void updateProduct(int theId);
	
	public void deleteProduct(int theId);
	
	public void save(Product theProduct);

}

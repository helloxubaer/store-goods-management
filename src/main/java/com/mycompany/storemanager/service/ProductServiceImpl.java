package com.mycompany.storemanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.storemanager.dao.ProductDAO;
import com.mycompany.storemanager.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	// inject product dao
	@Autowired
	private ProductDAO theProductDAO;

	@Override
	@Transactional
	public List<Product> getAllProducts() {
		return theProductDAO.getAllProducts();
	}

	@Override
	@Transactional
	public Product getProductById(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void updateProduct(int theId) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void deleteProduct(int theId) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void save(Product theProduct) {
		theProductDAO.save(theProduct);

	}

}

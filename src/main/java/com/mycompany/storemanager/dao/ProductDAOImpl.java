package com.mycompany.storemanager.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.mycompany.storemanager.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	// inject jpa entity
	// unrwrap hibernate session
	// leverage native hibernate functions
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Product> getAllProducts() {
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// create a query to gell all the products
		Query<Product> theQuery = 
				currentSession.createQuery("from Product",Product.class);
		List<Product> productList = theQuery.getResultList();
		return productList;
	}

	@Override
	public void save(Product theProduct) {
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theProduct);
		
	}

	@Override
	public Product getProductById(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProduct(int theId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(int theId) {
		// TODO Auto-generated method stub
		
	}

}

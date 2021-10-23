package com.mycompany.storemanager.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


import com.mycompany.storemanager.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	// inject jpa entity
	// unrwrap hibernate session
	// leverage native hibernate functions
	@Autowired
	@Qualifier("appDataEntityManagerFactoryBean")
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
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		Product theProduct = currentSession.get(Product.class, theId);
		return theProduct;
	}


	@Override
	public void deleteProduct(int theId) {
		// get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// create a query to get the product
		Query theQuery = currentSession.createQuery(
						"delete from Product where id=:theProductId");
		theQuery.setParameter("theProductId", theId);
		theQuery.executeUpdate();
		
	}

}

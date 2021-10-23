package com.mycompany.storemanager.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "store_details")
public class Product {

	// define fields
	// define constructors
	// add getter setters
	// to string
	// annotate fields and class
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	@Column(name = "product_name")
	@NotNull(message = "a name is required !")
	@Size(min = 1, message = "a name is required")
	private String name;
	
	@Column(name = "product_quantity")
	@Min(value = 0, message = "Must not be a negative number !")
	private Integer quantity;
	
	@NotNull(message = "a date: yyyy-MM-dd is required !")
	//@Pattern(regexp = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$",message = "Follow YYYY-MM-DD")
	@Temporal(TemporalType.DATE)
	@Column(name = "expired_on")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expireDate;
	
	public Product() {
	}

	public Product(String name, Integer quantity, Date expireDate) {
		this.name = name;
		this.quantity = quantity;
		this.expireDate = expireDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", quantity=" + quantity + ", expireDate=" + expireDate + "]";
	}
	
	
	
}

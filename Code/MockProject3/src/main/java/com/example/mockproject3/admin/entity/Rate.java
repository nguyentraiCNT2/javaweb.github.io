package com.example.mockproject3.admin.entity;
// Generated 20:03:11, 16 thg 4, 2024 by Hibernate Tools 5.6.15.Final

/**
 * Rate generated by hbm2java
 */
public class Rate implements java.io.Serializable {

	private Integer id;
	private Products products;
	private Users users;
	private int rate;
	private String description;

	public Rate() {
	}

	public Rate(Products products, Users users, int rate, String description) {
		this.products = products;
		this.users = users;
		this.rate = rate;
		this.description = description;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public int getRate() {
		return this.rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}

package com.example.mockproject3.admin.entity;
// Generated 20:03:11, 16 thg 4, 2024 by Hibernate Tools 5.6.15.Final

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Suppliers generated by hbm2java
 */
public class Suppliers implements Serializable {

	private Integer sid;
	private Serializable name;
	private Set productses = new HashSet(0);

	public Suppliers() {
	}

	public Suppliers(Serializable name) {
		this.name = name;
	}
	
	public Suppliers(Integer sid, Serializable name) {
		this.sid = sid;
		this.name = name;
	}

	public Suppliers(Serializable name, Set productses) {
		this.name = name;
		this.productses = productses;
	}

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Serializable getName() {
		return this.name;
	}

	public void setName(Serializable name) {
		this.name = name;
	}

	public Set getProductses() {
		return this.productses;
	}

	public void setProductses(Set productses) {
		this.productses = productses;
	}

}

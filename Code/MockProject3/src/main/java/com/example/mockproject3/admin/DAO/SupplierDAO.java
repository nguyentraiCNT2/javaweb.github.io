package com.example.mockproject3.admin.DAO;

import com.example.mockproject3.admin.entity.Suppliers;

import java.util.List;

public interface SupplierDAO {
	public List<Suppliers> getAllSupplier();
	public Suppliers getSupplierById(int id);
	public boolean insertSupplier(Suppliers category);
	public boolean updateSupplier(Suppliers category);
	public boolean deleteSupplier(int id); 
}

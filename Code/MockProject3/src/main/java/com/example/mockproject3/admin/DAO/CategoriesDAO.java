package com.example.mockproject3.admin.DAO;

import com.example.mockproject3.admin.entity.Categories;

import java.util.List;

public interface CategoriesDAO {
	public List<Categories> getAllCategory();
	public Categories getCategoryById(int id);
	public boolean insertCategory(Categories category);
	public boolean updateCategory(Categories category);
	public boolean deleteCategory(int id); 
}

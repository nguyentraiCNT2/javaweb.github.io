package com.example.day09.devmaster.edu.vn.dao;

import com.example.day09.devmaster.edu.vn.entity.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getAllProduct();
    Product getProductById(String id);
    boolean insertProduct(Product product);
    boolean updateProduct(Product product);
    boolean DeleteProduct(String id);
}

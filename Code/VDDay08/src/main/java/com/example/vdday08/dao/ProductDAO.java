package com.example.vdday08.dao;

import com.example.vdday08.entity.ProductEntity;

import java.util.List;

public interface ProductDAO {
    public List<ProductEntity> getAllProduct();

    public ProductEntity getProductbyMaSP(String maSP);

    boolean insertProduct(ProductEntity product);

    boolean updateProduct(ProductEntity product);

    boolean deleteProduct(String maSP);
}

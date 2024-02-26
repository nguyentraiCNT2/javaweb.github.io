package com.example.lab05hibernate01.dao;

import com.example.lab05hibernate01.entity.ProductEntity;


import java.util.List;

public interface ProductDAO {
    public List<ProductEntity> getAllProduct();

    public ProductEntity getProductbyMaSP(String maSP);

    boolean insertProduct(ProductEntity product);

    boolean updateProduct(ProductEntity product);

    boolean deleteProduct(String maSP);
}

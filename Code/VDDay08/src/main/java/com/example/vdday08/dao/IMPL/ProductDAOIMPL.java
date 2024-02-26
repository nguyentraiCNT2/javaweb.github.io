package com.example.vdday08.dao.IMPL;

import com.example.vdday08.dao.ProductDAO;
import com.example.vdday08.entity.ProductEntity;
import com.example.vdday08.utils.HibernateUil;
import org.hibernate.Session;

import java.util.List;

public class ProductDAOIMPL implements ProductDAO {
    @Override
    public List<ProductEntity> getAllProduct() {
        Session session = HibernateUil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            List<ProductEntity> list = session.createQuery("from ProductEntity ").list();
            session.getTransaction();
            session.close();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            session.close();
        }
        return null;
    }

    @Override
    public ProductEntity getProductbyMaSP(String maSP) {
        return null;
    }

    @Override
    public boolean insertProduct(ProductEntity product) {
        return false;
    }

    @Override
    public boolean updateProduct(ProductEntity product) {
        return false;
    }

    @Override
    public boolean deleteProduct(String maSP) {
        return false;
    }
}

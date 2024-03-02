package com.example.day09.devmaster.edu.vn.dao;

import com.example.day09.devmaster.edu.vn.entity.Product;
import com.example.day09.devmaster.edu.vn.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ProductDAOIMPL implements ProductDAO{
    @Override
    public List<Product> getAllProduct() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            List<Product> list = session.createQuery("from Product ").list();
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
    public Product getProductById(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Product product = (Product) session.createQuery("from Product where MaSP = :maSP").setParameter("maSP", id).uniqueResult();
            session.getTransaction();
            session.close();
            return product;
        }catch (Exception e){
            e.printStackTrace();
            session.close();
        }
        return null;
    }

    @Override
    public boolean insertProduct(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
            session.close();
            return true;

        }catch (Exception e){
            e.printStackTrace();
            session.close();
        }
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
            session.close();
            return true;

        }catch (Exception e){
            e.printStackTrace();
            session.close();
        }
        return false;
    }

    @Override
    public boolean DeleteProduct(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            int res = session.createQuery("delete  from Product where MaSP = :maSP").setParameter("maSP", id).executeUpdate();
            session.getTransaction().commit();
            session.close();
            if (res>0)
                return true;
        }catch (Exception e){
            e.printStackTrace();
            session.close();
        }
        return false;
    }
}

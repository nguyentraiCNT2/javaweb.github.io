package com.example.lab05hibernate01.dao.IMPL;

import com.example.lab05hibernate01.dao.EmployeeDAO;
import com.example.lab05hibernate01.entity.EMPLOYEE;
import com.example.lab05hibernate01.entity.ProductEntity;
import com.example.lab05hibernate01.utils.HibernateUil;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.util.List;

public class EmployeeDAOIMPL implements EmployeeDAO {
    @Override
    public List<EMPLOYEE> getAllEmployee() {
        Session session = HibernateUil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            List<EMPLOYEE> list = session.createQuery("from EMPLOYEE ").list();
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
    public EMPLOYEE getEmployeeByEMP_NAME(String EMP_NAME) {
        Session session = HibernateUil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            EMPLOYEE employee = (EMPLOYEE) session.createQuery("from EMPLOYEE where EMP_NAME = :EMP_NAME").setParameter("EMP_NAME", EMP_NAME).uniqueResult();
            session.getTransaction();
            session.close();
            return employee;
        }catch (Exception e){
            e.printStackTrace();
            session.close();
        }
        return null;
    }

    @Override
    public boolean insertEmployee(EMPLOYEE employee) {
        Session session = HibernateUil.getSessionFactory().openSession();
        try{

            session.beginTransaction();
            session.save(employee);
            session.getTransaction().rollback();
            session.close();
            return true;

        }catch (Exception e){
            e.printStackTrace();
            session.close();
        }
        return false;
    }

    @Override
    public boolean updateEmployee(EMPLOYEE employee) {
        Session session = HibernateUil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.update(employee);
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
    public boolean deleteProduct(BigDecimal EMP_ID) {
        Session session = HibernateUil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            int res = session.createQuery("delete  from EMPLOYEE where EMP_ID = :EMP_ID").setParameter("EMP_ID", EMP_ID).executeUpdate();
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

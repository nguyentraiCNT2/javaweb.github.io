package com.example.day09.devmaster.edu.vn.dao;

import com.example.day09.devmaster.edu.vn.entity.Employee;
import com.example.day09.devmaster.edu.vn.entity.Product;
import com.example.day09.devmaster.edu.vn.util.HibernateUtil;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.util.List;

public class EmployeeDAOIMPL implements EmployeeDAO{
    @Override
    public List<Employee> getAllEmployee() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            List<Employee> list = session.createQuery("from Employee ").list();
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
    public Employee getEmployeeById(BigDecimal id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            Employee employee = (Employee) session.createQuery("from Employee where EMP_ID = :EMP_ID").setParameter("EMP_ID", id).uniqueResult();
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
    public boolean insertEmployee(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(employee);
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
    public boolean updateEmployee(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
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
    public boolean deleteEmployee(BigDecimal id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            int res = session.createQuery("delete  from Employee where EMP_ID = :EMP_ID").setParameter("EMP_ID", id).executeUpdate();
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

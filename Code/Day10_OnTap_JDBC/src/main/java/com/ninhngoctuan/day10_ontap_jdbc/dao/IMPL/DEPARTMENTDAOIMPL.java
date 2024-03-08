package com.ninhngoctuan.day10_ontap_jdbc.dao.IMPL;

import com.ninhngoctuan.day10_ontap_jdbc.dao.DEPARTMENTDAO;

import com.ninhngoctuan.day10_ontap_jdbc.entity.DEPARTMENT;
import com.ninhngoctuan.day10_ontap_jdbc.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class DEPARTMENTDAOIMPL implements DEPARTMENTDAO {
    @Override
    public List<DEPARTMENT> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from DEPARTMENT", DEPARTMENT.class).list();
        }
    }

    @Override
    public List<DEPARTMENT> getDEPARTMENTByDEPT_NAME(String DEPT_NAME) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            List<DEPARTMENT> department =  session.createQuery("from DEPARTMENT where DEPT_NAME = :DEPT_NAME").setParameter("DEPT_NAME", DEPT_NAME).list();
            session.getTransaction().commit();
            session.close();
            return department;
        }catch (Exception e){
            e.printStackTrace();
            session.close();
        }
        return null;
    }

    @Override
    public DEPARTMENT getDEPARTMENTByid(Integer DEPT_ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            DEPARTMENT department = (DEPARTMENT) session.createQuery("from DEPARTMENT where DEPT_ID = :DEPT_ID").setParameter("DEPT_ID",DEPT_ID ).uniqueResult();
            session.getTransaction().commit();
            session.close();
            return department;
        }catch (Exception e){
            e.printStackTrace();
            session.close();
        }
        return null;
    }

    @Override
    public Boolean insertDEPARTMENT(DEPARTMENT department) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(department);
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
    public Boolean updateDEPARTMENT(DEPARTMENT department) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.update(department);
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
    public Boolean deleteDEPARTMENTByid(Integer DEPT_ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            int res = session.createQuery("delete  from DEPARTMENT where DEPT_ID = :DEPT_ID").setParameter("DEPT_ID", DEPT_ID).executeUpdate();
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

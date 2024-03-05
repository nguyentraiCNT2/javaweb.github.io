package com.ninhngoctuan.day10_ontap_jdbc.dao.IMPL;

import com.ninhngoctuan.day10_ontap_jdbc.dao.DEPARTMENTDAO;
import com.ninhngoctuan.day10_ontap_jdbc.entity.DEPARTMENTEntity;
import com.ninhngoctuan.day10_ontap_jdbc.entity.TIMEKEEPEREntity;
import com.ninhngoctuan.day10_ontap_jdbc.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class DEPARTMENTDAOIMPL implements DEPARTMENTDAO {
    @Override
    public List<DEPARTMENTEntity> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            List<DEPARTMENTEntity> list = session.createQuery("from DEPARTMENTEntity ").list();
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
    public List<DEPARTMENTEntity> getDEPARTMENTByDEPT_NAME(String DEPT_NAME) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            List<DEPARTMENTEntity> department =  session.createQuery("from DEPARTMENTEntity where DEPT_NAME = :DEPT_NAME").setParameter("DEPT_NAME", DEPT_NAME).list();
            session.getTransaction();
            session.close();
            return department;
        }catch (Exception e){
            e.printStackTrace();
            session.close();
        }
        return null;
    }

    @Override
    public DEPARTMENTEntity getDEPARTMENTByid(Integer DEPT_ID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            DEPARTMENTEntity department = (DEPARTMENTEntity) session.createQuery("from DEPARTMENTEntity where DEPT_ID = :DEPT_ID").setParameter("DEPT_ID",DEPT_ID ).uniqueResult();
            session.getTransaction();
            session.close();
            return department;
        }catch (Exception e){
            e.printStackTrace();
            session.close();
        }
        return null;
    }

    @Override
    public Boolean insertDEPARTMENT(DEPARTMENTEntity department) {
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
    public Boolean updateDEPARTMENT(DEPARTMENTEntity department) {
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
            int res = session.createQuery("delete  from DEPARTMENTEntity where DEPT_ID = :DEPT_ID").setParameter("DEPT_ID", DEPT_ID).executeUpdate();
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

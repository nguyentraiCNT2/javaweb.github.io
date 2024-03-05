package com.ninhngoctuan.day10_ontap_jdbc.dao.IMPL;

import com.ninhngoctuan.day10_ontap_jdbc.dao.TIMKEEPERDAO;
import com.ninhngoctuan.day10_ontap_jdbc.entity.TIMEKEEPEREntity;
import com.ninhngoctuan.day10_ontap_jdbc.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class TIMKEEPERDAOIMPL implements TIMKEEPERDAO {
    @Override
    public List<TIMEKEEPEREntity> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            List<TIMEKEEPEREntity> list = session.createQuery("from TIMEKEEPEREntity ").list();
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
    public TIMEKEEPEREntity getTIMEKEEPERByid(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            TIMEKEEPEREntity employee = (TIMEKEEPEREntity) session.createQuery("from TIMEKEEPEREntity where Timekeeper_Id = :Timekeeper_Id").setParameter("Timekeeper_Id", id).uniqueResult();
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
    public Boolean insertTIMEKEEPER(TIMEKEEPEREntity timekeeper) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(timekeeper);
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
    public Boolean updateTIMEKEEPER(TIMEKEEPEREntity timekeeper) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.update(timekeeper);
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
    public Boolean deleteTIMEKEEPERByid(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            int res = session.createQuery("delete  from TIMEKEEPEREntity where Timekeeper_Id = :Timekeeper_Id").setParameter("Timekeeper_Id", id).executeUpdate();
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

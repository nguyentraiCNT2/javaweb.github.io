package com.ninhngoctuan.day10_ontap_jdbc.dao.IMPL;

import com.ninhngoctuan.day10_ontap_jdbc.dao.EMPLOYEEDAO;
import com.ninhngoctuan.day10_ontap_jdbc.entity.EMPLOYEEEntity;
import com.ninhngoctuan.day10_ontap_jdbc.util.HibernateUtil;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.util.List;

public class EMPLOYEEDAOIMPL implements EMPLOYEEDAO {
    @Override
    public List<EMPLOYEEEntity> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            List<EMPLOYEEEntity> list = session.createQuery("from EMPLOYEEEntity ").list();
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
    public List<EMPLOYEEEntity> getEMPLOYEEbyEMP_NAME(String EMP_NAME) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            List<EMPLOYEEEntity> employee =  session.createQuery("from EMPLOYEEEntity where EMP_NAME = :EMP_NAME").setParameter("EMP_NAME", EMP_NAME).list();
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
    public EMPLOYEEEntity getEMPLOYEEByid(BigDecimal id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            EMPLOYEEEntity employee = (EMPLOYEEEntity) session.createQuery("from EMPLOYEEEntity where EMP_ID = :EMP_ID").setParameter("EMP_ID", id).uniqueResult();
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
    public Boolean insertEMPLOYEE(EMPLOYEEEntity employee) {
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
    public Boolean updateEMPLOYEE(EMPLOYEEEntity employee) {
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
    public Boolean deleteEMPLOYEEByid(BigDecimal id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            int res = session.createQuery("delete  from EMPLOYEEEntity where EMP_ID = :EMP_ID").setParameter("EMP_ID", id).executeUpdate();
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

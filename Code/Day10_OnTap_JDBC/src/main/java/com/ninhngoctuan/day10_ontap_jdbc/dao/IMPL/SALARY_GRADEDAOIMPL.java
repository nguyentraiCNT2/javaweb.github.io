package com.ninhngoctuan.day10_ontap_jdbc.dao.IMPL;

import com.ninhngoctuan.day10_ontap_jdbc.dao.SALARY_GRADEDAO;
import com.ninhngoctuan.day10_ontap_jdbc.entity.SALARY_GRADE;
import com.ninhngoctuan.day10_ontap_jdbc.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class SALARY_GRADEDAOIMPL implements SALARY_GRADEDAO {
    @Override
    public List<SALARY_GRADE> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            List<SALARY_GRADE> list = session.createQuery("from SALARY_GRADE ").list();
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
    public SALARY_GRADE getSALARY_GRADEByid(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            SALARY_GRADE employee = (SALARY_GRADE) session.createQuery("from SALARY_GRADE where GREDE = :GREDE").setParameter("GREDE", id).uniqueResult();
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
    public Boolean insertSALARY_GRADE(SALARY_GRADE salaryGrade) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.save(salaryGrade);
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
    public Boolean updateSALARY_GRADE(SALARY_GRADE salaryGrade) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            session.update(salaryGrade);
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
    public Boolean deleteSALARY_GRADEByid(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.beginTransaction();
            int res = session.createQuery("delete  from SALARY_GRADE where GREDE = :GREDE").setParameter("GREDE", id).executeUpdate();
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

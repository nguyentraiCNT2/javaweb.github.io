package com.example.mockproject3.admin.DAO;

import com.example.mockproject3.admin.Utils.HibernateUtils;
import com.example.mockproject3.admin.entity.Suppliers;
import org.hibernate.Session;

import java.util.List;

public class SupplierDAOImpl implements SupplierDAO {
	@Override
	public List<Suppliers> getAllSupplier() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<Suppliers> list = session.createQuery("from Suppliers", Suppliers.class).getResultList();
			session.getTransaction().commit();
			session.close();
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return null;
	}
	
	@Override
	public Suppliers getSupplierById(int id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Suppliers category = (Suppliers)session.createQuery("from Suppliers where Sid = :sid").setParameter("sid", id).uniqueResult();
			session.getTransaction().commit();
			session.close();
			return category;
		} catch (Exception ex) {
				ex.printStackTrace();
				session.close();
		}
		return null;

	}

	@Override
	public boolean insertSupplier(Suppliers supplier) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(supplier);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return false;
	}

	@Override
	public boolean updateSupplier(Suppliers supplier) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(supplier);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return false;
	}

	@Override
	public boolean deleteSupplier(int id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			int res = session.createQuery("delete from Suppliers where Sid = :sid").setParameter("sid", id).executeUpdate();
			session.getTransaction().commit();
			session.close();
			if(res>0)
				return true;
				
		} catch (Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return false;
	}
}

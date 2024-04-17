package com.example.mockproject3.admin.DAO;


import com.example.mockproject3.admin.Utils.HibernateUtils;
import com.example.mockproject3.admin.entity.Categories;
import org.hibernate.Session;

import java.util.List;


public class CategoriesDAOImpl implements CategoriesDAO{

	@Override
	public List<Categories> getAllCategory() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<Categories> list = session.createQuery("from Categories", Categories.class).getResultList();
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
	public Categories getCategoryById(int id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Categories category = (Categories)session.createQuery("from Categories where Cid = :cid").setParameter("cid", id).uniqueResult();		
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
	public boolean insertCategory(Categories category) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(category);
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
	public boolean updateCategory(Categories category) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(category);
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
	public boolean deleteCategory(int id) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			int res = session.createQuery("delete from Categories where Cid = :cid").setParameter("cid", id).executeUpdate();
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

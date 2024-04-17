package com.example.mockproject3.admin.Utils;

import com.example.mockproject3.admin.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateUtils {
	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;
	static {
		try {
			if(sessionFactory == null) {
				standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
				MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
				metadataSources.addAnnotatedClass(Categories.class);
				metadataSources.addAnnotatedClass(Suppliers.class);
				metadataSources.addAnnotatedClass(FavouriteProduct.class);
				metadataSources.addAnnotatedClass(Orders.class);
				metadataSources.addAnnotatedClass(OrderDetails.class);
				metadataSources.addAnnotatedClass(Products.class);
				metadataSources.addAnnotatedClass(Rate.class);
				metadataSources.addAnnotatedClass(Size.class);
				metadataSources.addAnnotatedClass(Users.class);
				Metadata metadata = metadataSources.getMetadataBuilder().build();
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			}
		}catch(Throwable ex) {
			ex.printStackTrace();
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}

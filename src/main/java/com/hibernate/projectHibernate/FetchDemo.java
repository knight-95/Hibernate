package com.hibernate.projectHibernate;

import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		// GET , LOAD
		Student student = (Student)session.get(Student.class, 102);
		System.out.println(student);		
				
		
		Address ad = (Address)session.load(Address.class, 1);
		System.out.println(ad);
		session.close();
		factory.close();
	}

}

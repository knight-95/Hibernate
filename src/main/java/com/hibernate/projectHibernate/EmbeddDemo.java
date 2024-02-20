package com.hibernate.projectHibernate;

import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddDemo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		Student student1 = new Student();
		student1.setId(14137);
		student1.setName("Ravi");
		student1.setCity("Jhansi");

		Certificate certi = new Certificate();
		certi.setCourse("iOS");
		certi.setDuration("3 months");

		//saving certificate1 into student1
		student1.setCerti(certi);
		
		
		Student student2 = new Student();
		student2.setId(14134);
		student2.setName("Ashutosh");
		student2.setCity("Karera");
		
		

		Certificate certi2 = new Certificate();
		certi2.setCourse("Android");
		certi2.setDuration("2 months");
		student2.setCerti(certi2);

		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();

		// saving objects
				
		s.persist(student1);
		s.persist(student2);
		
		tx.commit();
		
		s.close();
		factory.close();

	}

}

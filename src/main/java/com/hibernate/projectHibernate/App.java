package com.hibernate.projectHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Project Started!");
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		//creating student
		Student st = new Student();
		st.setId(102);
		st.setName("Kirti");
		st.setCity("Indore");
		System.out.println(st);
		
		Session session= factory.openSession();
		
		//starting a transaction
		session.beginTransaction();
		session.save(st);
		session.getTransaction().commit();
		session.close();
	}
}

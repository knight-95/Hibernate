package com.hibernate.projectHibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project Started!");
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		// creating student
		Student st = new Student();
		st.setId(102);
		st.setName("Yash Gupta");
		st.setCity("Indore");
		System.out.println(st);

		// creating object of Student class
		Address ad = new Address();
		ad.setStreet("Indra Nagar");
		ad.setCity("Gwalior");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setTemperature(13.2);
		System.out.println(ad);

		// Reading Image
		FileInputStream fis = new FileInputStream("src/main/java/car.jpg");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);

		Session session = factory.openSession();

		// starting a transaction
		session.beginTransaction();
		session.save(st);

		// save is deprecated from Hibernate 6.0
//		session.save(ad);
		session.persist(ad);
		session.getTransaction().commit();
		session.close();
	}
}

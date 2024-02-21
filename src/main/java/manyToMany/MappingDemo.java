package manyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Emp e1 = new Emp();
		Emp e2 = new Emp();

		e1.setEid(24);
		e1.setName("Ali");

		e2.setEid(25);
		e2.setName("Rawat");

		Project p1 = new Project();
		Project p2 = new Project();

		p1.setPid(120);
		p1.setProjectName("Training Management System");

		p2.setPid(122);
		p2.setProjectName("Canteen Management System");

		List<Emp> list1 = new ArrayList<Emp>();
		List<Project> list2 = new ArrayList<Project>();

		list1.add(e1);
		list1.add(e2);
		list2.add(p1);
		list2.add(p2);

		e1.setProjects(list2);
		p2.setEmps(list1);

		// session
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		// save
		session.persist(e1);
		session.persist(e2);
		session.persist(p1);
		session.persist(p2);

		tx.commit();
		session.close();
		factory.close();
	}

}

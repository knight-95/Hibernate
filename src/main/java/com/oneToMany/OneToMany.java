package com.oneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToMany {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// creating question
		Question1 q1 = new Question1();
		q1.setQuestionId(12121);
		q1.setQuestion("What is JAVA ?");

		// creating answer
		Answer1 answer = new Answer1();
		answer.setAnswerId(343);
		answer.setAnswer("Java is a programming langugae");
		answer.setQuestion(q1);

		Answer1 answer1 = new Answer1();
		answer1.setAnswerId(33);
		answer1.setAnswer("Object oriented language");
		answer1.setQuestion(q1);

		Answer1 answer2 = new Answer1();
		answer2.setAnswerId(363);
		answer2.setAnswer("Spring Boot");
		answer2.setQuestion(q1);

		List<Answer1> list = new ArrayList<Answer1>();
		list.add(answer);
		list.add(answer1);
		list.add(answer2);
		q1.setAnswers(list);

		// session
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		// save
		session.persist(q1);
		session.persist(answer);
		session.persist(answer1);
		session.persist(answer2);


		// fetching......
//		Question1 q = (Question1) session.get(Question1.class, 1212);
//		System.out.println(q.getQuestion());
//
//		for (Answer1 a : q.getAnswers()) {
//			System.out.println(a.getAnswer());
//		}

		tx.commit();
		session.close();
		factory.close();
	}

}

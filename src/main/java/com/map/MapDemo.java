package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		// creating question
		Question q1 = new Question();
		q1.setQuestionId(12121);
		q1.setQuestion("What is JAVA ?");

		// creating answer
		Answer answer = new Answer();
		answer.setAnswerId(343);
		answer.setAnswer("Java is a programming langugae");
		q1.setAns(answer);

		// creating question
		Question q2 = new Question();
		q2.setQuestionId(242);
		q2.setQuestion("What is collection Framework ?");

		// creating answer
		Answer answer1 = new Answer();
		answer1.setAnswerId(344);
		answer1.setAnswer("API to work with objects in JAVA");
		q2.setAns(answer1);

		// session
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		// save
		session.persist(q1);
		session.persist(q2);
		session.persist(answer);
		session.persist(answer1);

		tx.commit();
		
		
		//fetching......
		 Question newQuestion = (Question)session.get(Question.class, 12121);
		 System.out.println(newQuestion.getQuestion());
		 System.out.println(newQuestion.getAns().getAnswer());

		session.close();
		factory.close();
	}

}

package com.fayaz.hibernate.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Student;

public class StudentUpdateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			//get a student
			int stuId = 1;
			Student myStudent = session.get(Student.class, stuId);
			System.out.println("getting student by id : " + myStudent);

			//update that student
			System.out.println("updating student......");
			myStudent.setF_name("Sri");
			session.update(myStudent); //not mandatory. without it also, it updates

			//update email for all students
			System.out.println("updating email for all students......");
			session.createQuery("update Student set email='foo@yahoo.com' ").executeUpdate();

			session.getTransaction().commit();
			System.out.println("done !");

		} finally {
			factory.close();
		}
	}
}

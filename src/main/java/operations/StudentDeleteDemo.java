package com.fayaz.hibernate.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Student;

public class StudentDeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			//get a student
			int stuId = 7;
			Student myStudent = session.get(Student.class, stuId);
			System.out.println("getting student by id : " + myStudent);

			//delete that student
			System.out.println("deleting student......");
			session.delete(myStudent);

			//delete students
			System.out.println("deleting  students......");
			session.createQuery("delete from Student where id=2 ").executeUpdate();

			session.getTransaction().commit();
			System.out.println("done !");

		} finally {
			factory.close();
		}
	}

}

package com.fayaz.hibernate.session;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Student;

public class StudentReadDemo {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {

			//read a student by ID from DB
			session.beginTransaction();
			int stuId = 3;
			Student myStu = session.get(Student.class, stuId);
			System.out.println("getting student by id : " + myStu);


			//fetching all sudents
			List<Student> stuList = session.createQuery("from Student").getResultList();
			displayStudents(stuList);

			//to fetch based on last name
			stuList = session.createQuery("from Student s where s.l_name='sk' ").getResultList();
			displayStudents(stuList);

			//to fetch based on last name or First name
			stuList = session.createQuery("from Student s where s.l_name='sk' OR s.f_name='rahul' ").getResultList();
			displayStudents(stuList);

			//using LIKE
			stuList = session.createQuery("from Student s where s.email LIKE '%@gmail.com' ").getResultList();
			displayStudents(stuList);
			session.getTransaction().commit();
			System.out.println("done !");

		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> stuList) {
		for (Student s : stuList) {
			System.out.println(s);
		}
	}

}

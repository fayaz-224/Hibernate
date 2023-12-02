package operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.Student;

public class StudentCreateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			System.out.println("creating new students");
			Student stu1 = new Student("fizz", "sk", "fizz@gmail.com");
			Student stu2 = new Student("gopal", "kk", "gopal@outlook.com");
			Student stu3 = new Student("suji", "j", "suji@gmail.com");
			Student stu4 = new Student("rahul", "k", "rahul@yahoo.com");
			Student stu5 = new Student("joe", "s", "joe@gmail.com");

			session.beginTransaction();

			System.out.println("saving students");
			session.save(stu1);
			session.save(stu2);
			session.save(stu3);
			session.save(stu4);
			session.save(stu5);

			session.getTransaction().commit();

			System.out.println("done !");

		} finally {
			factory.close();
		}

	}

}

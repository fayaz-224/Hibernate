package UnitTests;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			System.out.println("connecting to DB" + jdbcUrl);
			Connection mycon = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("connection succesful");
			mycon.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
	
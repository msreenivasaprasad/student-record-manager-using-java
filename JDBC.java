import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class JDBC {
	public static final String uname = "root";
	public static final String password = "2410";
	public static java.sql.Statement stmt = null;
	public static Connection conn = null;

	public static void establish() {
		try {

			String url = "jdbc:mysql://localhost:3306/prasad";
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, uname, password);
			System.out.println("Connection Estlablished");

		} catch (Exception e) {
			System.out.println("Not Connected");

		}
	}

	public static void clearrecord() {
		try {
			stmt = conn.createStatement();
			stmt.execute("delete  from student");
		} catch (SQLException e) {

		}

	}

	public static String fromdb(String id,int i) {
		String temp=new String();
		try {
			stmt = conn.createStatement();
			stmt.execute("select * from student where student_id=" + id);
			ResultSet res = stmt.getResultSet();
							
				while(res.next()) {
				temp = res.getString(i);
				i++;
				System.out.println(temp);
				}
				
			

		} catch (Exception e) {
			System.out.println("Exception");
		}
		finally {
			return temp;
		}
	}

	public static void intodb(String id, String name, String branch, String cgpa, String phone, String college) {
		{

			try {
				stmt = conn.createStatement();
				stmt.execute("insert into student  value(" + id + ",\"" + name + "\"," + "\"" + branch + "\"," + cgpa
						+ ",\"" + phone + "\",\"" + college + "\")");
			} catch (Exception e) {

			}
		}

	}

	public static void terminate() {
		try {
			if (conn != null) {
				conn.close();
				System.out.println("Connection Terminated");
			}
		} catch (Exception e) {

		}
	}
}

package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update_Record {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&password=1234");
		
		Statement st =con.createStatement();
		st.executeUpdate("update demo1 set name='Rakesh' where age='21'");
		System.out.println("Record updated");

	}

}

package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update_Record2 {
	public static void main(String[] args) {
		String sql="update demo1 set name='Sid', age='21' where sal='25'";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&password=1234");
		
			
			Statement st=con.createStatement();
		st.executeUpdate(sql);
			System.out.println("Record updated");
			

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert_MultipleRecord {

	public static void main(String[] args) {
		
		String sql="insert into demo1 (name,age,sal) values ('Siddharth', 20,200), ('XYz', 50,33),('KUCHv', 20,33) ";	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&password=1234");
			Statement st=con.createStatement();
			
			st.executeUpdate(sql);
			System.out.println("Record updated successfully");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

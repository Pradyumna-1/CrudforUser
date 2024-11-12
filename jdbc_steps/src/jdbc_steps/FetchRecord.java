package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchRecord {
	public static void main(String[] args) {
		String sql="select * from demo1 where age=50";
		try {   
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&password=1234");
			Statement stmt=con.createStatement();
			
			ResultSet rs= stmt.executeQuery(sql);
//			stmt.executeUpdate("insert into jdbc_steps.demo1 values('Rohit',22,55)");
			while(rs.next()) {
				
				String name=rs.getString(1);
				int age=rs.getInt(2);
				double sal=rs.getDouble(3);
				System.out.println("name="+name+" age="+age+ " sal="+ sal);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
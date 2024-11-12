package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Table_Creation {
	public static void main(String[] args) {
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver class loaded");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps", "root","1234");
				System.out.println(con);
				Statement stmt=con.createStatement();
				stmt.execute("create table demo1(name varchar(45),age int,sal int)");
				System.out.println("demo table is created");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	

	}

}

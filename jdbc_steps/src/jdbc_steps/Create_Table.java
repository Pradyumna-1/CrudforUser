package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_Table {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class created");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&password=1234");
			System.out.println("Connection established ");
			Statement stmt=con.createStatement();
			
			System.out.println("Platform created");
			
			
			
//			stmt.execute("insert into jdbc_steps.demo values ('ram',24,55)");
//			stmt.executeUpdate("insert into jdbc_steps.demo1 values('Rohit',22,55)");
//			executeUpdate ---> It can work with only DML statement and the return type is int 
//			stmt.execute("create table employe (eid int primarykey, ename varchar(25), esla int, adress varchar(25)) ");
			stmt.execute("CREATE TABLE emp (eid INT PRIMARY KEY, ename VARCHAR(25), esal INT)");
			System.out.println("data inserted successfully");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
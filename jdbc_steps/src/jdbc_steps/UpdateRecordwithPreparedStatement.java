package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateRecordwithPreparedStatement {
	public static void main(String[] args) {
		String sql="delete from demo1 name = (?) WHERE name = ''";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&password=1234");
		
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, "Nirakar");
			pst.executeUpdate();
			System.out.println("Record updated");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
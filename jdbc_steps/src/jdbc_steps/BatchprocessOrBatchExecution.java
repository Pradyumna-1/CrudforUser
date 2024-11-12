package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchprocessOrBatchExecution {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&password=1234");
			st=con.createStatement();
			
//			st.execute("insert into demo1 values('Sourav',22,28)");
//			System.out.println("Data inserted");
			
			String sql1="insert into demo1 values('Virat',39,80)";
			String sql2="update demo1 set sal=80 where name='Siddharth' ";
			String sql3="delete from demo1 where name='KUCHV'";
			
			
			
			st.addBatch(sql1);
			st.addBatch(sql2);
			st.addBatch(sql3);
			
			st.executeBatch();
			System.out.println("Operation completed");
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		finally {
			if(st !=null) {
				try {
					st.close();
					System.out.println("Statement Closed");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			else if(con !=null) {
				
				try {
					con.close();
					System.out.println("Connection closed ");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
	}
	}
}
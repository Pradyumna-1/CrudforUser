package jdbc_steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUDApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_steps?user=root&password=1234");

			while(true) {
				System.out.println("1. Insert data");
				System.out.println("2. Updat data");
				System.out.println("3. Delete data");
				System.out.println("4. Stop execution");
				System.out.println("Choose an option from the above : ");
				int choice=sc.nextInt();
				switch(choice) {
				case 1: // Inserting Data
					
					System.out.println("Enter your id");
					int id=sc.nextInt();
					System.out.println("Enter your name");
					String name=sc.next();
					System.out.println("Enter your sal");
					double sal=sc.nextDouble();
					
					String q1="insert into emp (eid,ename,esal) values (?, ?, ?)";
					PreparedStatement pst=con.prepareStatement(q1);
					
					pst.setInt(1, id);
					pst.setString(2, name);
					pst.setDouble(3, sal);
					pst.executeUpdate();
					System.out.println("Data inserted Sucessfully");
					break;
				case 2://Update 
					System.out.println("Update the data based on id");
					System.out.println("Enter the id");
					int uid=sc.nextInt();
					System.out.println("Enter the new name ");
					String uename=sc.next();
					
					System.out.println("Enter the new sal");
					double usal=sc.nextDouble();
					
					String q2="update emp set ename=?, esal=? where eid=?";
					PreparedStatement upst=con.prepareStatement(q2);
					upst.setString(1, uename);
					upst.setDouble(2, usal);
					upst.setInt(3, uid);
					upst.executeUpdate();
					
					System.out.println("Data Updated");
					
					break;
					
				case 3: //Delete
					
					System.out.println("Delete the data based on the id ");
					System.out.println("Enter id");
					int did=sc.nextInt();
//					System.out.println("Eneter ");
//					String dename=sc.next();
//					double dsal=sc.nextDouble();
					
					String q3="delete from emp where eid=?";
					
					PreparedStatement dpst=con.prepareStatement(q3);
					dpst.setInt(1, did);
					
					dpst.executeUpdate();
					
					System.out.println("Record Deleted");
				break;
				
				case 4:
					sc.close();
					con.close();
					System.out.println("Programme terminated");
				return;	
					
				default:
					System.out.println("Select the correct given option");
				}
			
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

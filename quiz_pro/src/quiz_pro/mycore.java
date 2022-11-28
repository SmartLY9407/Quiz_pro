package quiz_pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class mycore {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema", "root", "Light@2010");
			System.out.println("For check the score Enter the following Details: ");
			System.out.println("Enter Youer ID: ");
			int id = sc.nextInt();
			System.out.println("Enter youer Name");
			String name = sc.next();
			String qurii = "select * from studentdetails where sr=? and name=?";
			PreparedStatement ps = con.prepareStatement(qurii);
			ps.setInt(1, id);
			ps.setString(2, name);
			ResultSet rs = ps.executeQuery();
			rs.next();
			System.out.println("Your Score is : "+rs.getInt(3));
			
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}

}

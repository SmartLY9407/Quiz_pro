package quiz_pro;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Set;

public class rank {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema", "root", "Light@2010");
			String dec = "select * from studentdetails order by score desc";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(dec);
			int i = 1;
			System.out.println("Enter your ID: ");
			int id = sc.nextInt();
			while(rs.next())
			{
				int id2 = rs.getInt(1);
				if(id == id2)
				{
					System.out.println("your score is "+rs.getInt(3)+" And Rank is : "+i);
				}
				i++;
			}
			
		}
		catch(Exception e){
			System.out.println(e);
		}

	}
}

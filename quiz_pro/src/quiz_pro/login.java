package quiz_pro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import javax.imageio.spi.RegisterableService;

public class login {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int	in = 1;
		 while(in == 1 || in == 2)
		 {
			 System.out.println("you want to login press 1 and for signup press 2 and 3 for EXIT");
			 int ni = sc.nextInt();
			 in = ni;
			 if(in==1)
			 {
			 Scanner sc2 = new Scanner(System.in);
			 System.out.println("Enter name: ");
			 String name = sc.next();
			 System.out.println("Enter ID: ");
			 int id = sc.nextInt();
			 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema", "root", "Light@2010");
				String qri = "select * from studentdetails where sr = ?";
				PreparedStatement ps = con.prepareStatement(qri);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				rs.next();
				int id2 = rs.getInt(1);
				String name2 = rs.getString(2);
				if(id==id2 && name.equalsIgnoreCase(name2))
				{
					int ch;
					Scanner sc3 = new Scanner(System.in); 
					System.out.println("You have log in successfully.....");
					
					System.out.println(" 1 } for strt test ");
					System.out.println(" 2 } for see rank ");
					System.out.println(" 3 } for see your score");
					System.out.println(" 4 } for see all scores");
					System.out.println(" 5 } for Entring question");
					System.out.println("Enter the choice as follows:  ");
					ch = sc3.nextInt();
					switch(ch)
					{
						case 1:
							
							
					}
					
				}
				else
				{
					System.out.println("ID is invalid");
				}
				con.close();
				ps.close();
				
			 }catch(Exception e)
			 {
				 System.out.println(e);
			 }
		 }else if(in==2)
		 {
			 Scanner sc2 = new Scanner(System.in);
			 System.out.println("Enter your name: ");
			 String name = sc2.nextLine();
			 System.out.println("Enter your id: ");
			 int id = sc.nextInt();
			 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema", "root", "Light@2010");
				String str = "insert into studentdetails(sr,name)values(?,?)";
				PreparedStatement ps = con.prepareStatement(str);
				ps.setInt(1, id);
				ps.setString(2, name.toLowerCase());
				int i = ps.executeUpdate();
				System.out.println(" ID and NAME inserted ");
				
			 }
			 catch(Exception e)
			 {
				 System.out.println(e);
			 }
			 
		 }	
			 
		 }

	}

}

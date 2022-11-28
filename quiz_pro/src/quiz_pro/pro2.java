package quiz_pro;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;

public class pro2 {
	
	
	public static void main(String[] args)throws Exception{
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			try {
				
			
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema", "root", "Light@2010");
            Statement statement = con.createStatement();
            String query = "insert into studentdetails values(1,'shivam',9)";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
            	String Score = (String) rs.getString(3);
            	System.out.println(Score);
            }
            	con.close();
            	statement.close();
			}
			catch(Exception e){
				System.out.println(e);
			}
	}
}
	 


package quiz_pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class pro {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Scanner sc1 = new Scanner(System.in);
			Scanner sc2 = new Scanner(System.in);
			Scanner sc3 = new Scanner(System.in);
			Scanner sc4 = new Scanner(System.in);
			Scanner sc5 = new Scanner(System.in);
			Scanner sc6 = new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema", "root", "Light@2010");

			// create the sql statement
			PreparedStatement ps =  con.prepareStatement("Insert into test(qno,question,A,B,C,D,answer) values(?,?,?,?,?,?,?)");
			
			System.out.print("Enter the sr no: ");
			int sr = sc.nextInt();
			System.out.println("Enter Question: ");
			String s1 = sc1.nextLine();
			System.out.println("option A: ");
			String s2 = sc2.nextLine();
			System.out.println("option B: ");
			String s3 = sc3.next();
			System.out.println("option C: ");
			String s4 = sc4.nextLine();
			System.out.println("option D: ");
			String s5 = sc5.nextLine();
			System.out.println("Answer: ");
			String s6 = sc6.nextLine();
			ps.setInt(1, sr);
			ps.setString(2, s1);
			ps.setString(3, s2);
			ps.setString(4, s3);
			ps.setString(5, s4);
			ps.setString(6, s5);
			ps.setString(7, s6);
			int i = ps.executeUpdate();
			System.out.println("Insertion successfully...");

			// close the resources.
			con.close();
			ps.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		}

}

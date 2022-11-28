package quiz_pro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class pro4 {
	//static Connection con;
	public static void main(String[] args) {
		System.out.println("Wellcome to Quiz");
		String y = "yes";
		String q = "quit";
		int score = 0;
			try {
				Scanner sc1 = new Scanner(System.in);
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema", "root", "Light@2010");
				String query = "Select * from test";
				String q2 = ("Insert into studentdetails(sr,name) values(?,?)");
				System.out.println("Enter id: ");
				int id = sc1.nextInt();
				System.out.println("Enter name: ");
				String name = sc1.next();
				PreparedStatement st1 = con.prepareStatement(q2);
				st1.setInt(1, id);
				st1.setString(2, name);
				int val = st1.executeUpdate();
				Statement st = con.createStatement();
				ResultSet set = st.executeQuery(query);
				while(set.next()) {
					Scanner sc = new Scanner(System.in);
					System.out.println("Do you want to solve next question ?(YES/QUIT)");
					String s = sc.next();
					if(y.equalsIgnoreCase(s) ) {
						String question = set.getString(2);
						String ans = set.getString(7);
						String op4 = set.getString(6);
						String op3 = set.getString(5);
						String op2 = set.getString(4);
						String op1 = set.getString(3);
						System.out.println(question);
						System.out.println(" 1 } "+op1);
						System.out.println(" 2 } "+op2);
						System.out.println(" 3 } "+op3);
						System.out.println(" 4 } "+op4);
						System.out.println("Enter your answar number : ");
						int output = sc.nextInt();
						String ans2 = set.getString(output+2);
						if(ans.equals(ans2)) {
							score++;
						}
					  }else {
						  break;
					  }
					
					}
				PreparedStatement st3 = con.prepareStatement("Update studentdetails set score = ? where sr = ? ");
				st3.setInt(1, score);
				st3.setInt(2, id);
				int v2 = st3.executeUpdate();
				con.close();
				System.out.println("Your Final Score" +score);
				}catch(Exception e) {
					System.out.println(e);
				}
			
			
		}
		
		
	}
package ferhat.jdbcPractice;

import java.sql.*;

public class A {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");
		Statement st =con.createStatement();
		
		ResultSet veri=st.executeQuery("Select * from student");

		while (veri.next()) {
			System.out.println(veri.getString("id")+veri.getString(2)+veri.getInt(3));
			
		}
	}

}

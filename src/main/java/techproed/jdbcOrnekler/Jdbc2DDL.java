package techproed.jdbcOrnekler;

import java.sql.*;

public class Jdbc2DDL {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {


		Class.forName("com.mysql.cj.jdbc.Driver");
		
	       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");
	 
	        Statement st = con.createStatement();
	        
	        

	}

}

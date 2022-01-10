package techproed.jdbcOrnekler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Jdbs2DDL {

	public static void main(String[] args) {


		Class.forName("com.mysql.cj.jdbc.Driver");
		
	       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");
	 
	        Statement st = con.createStatement();

	}

}

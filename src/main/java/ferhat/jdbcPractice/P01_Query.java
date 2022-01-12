package ferhat.jdbcPractice;
import java.sql.*;
public class P01_Query {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {


		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");
		Statement st =con.createStatement();
		
		ResultSet veri=st.executeQuery("select isim, maas FROM personel WHERE id=123456789");

		while (veri.next()) {
			System.out.println(veri.getString("isim")+veri.getInt("maas"));
			System.out.println("Personel adi : "+veri.getString(1) + " maasi : " + veri.getInt(2));
		}
		
		  while(veri.next()) {
	    	   System.out.println(veri.getString("isim")  + veri.getInt("maas")  );
	    	   
	    	   System.out.println("Personel Adi:"+ veri.getString(1)+"Maas:"+ veri.getInt(2) );
	}
	}
}

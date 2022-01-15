package ajanda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlConnect {
static Statement st;
static Connection con;
	
public void sqlbagla() throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");
    Statement st = con.createStatement();
    
}
	public void tabloOlustur(String tabloAdi, String degiskenler) throws SQLException {
		 String tablo="CREATE TABLE "+tabloAdi+" "+degiskenler;
		 st.execute(tablo);
		 System.out.println("tablo olustu");
	}
	
	public void tabloSil(String tabloAdi) throws SQLException {
		String sil="DROP TABLE " + tabloAdi;
		st.execute(sil);
		System.out.println("tablo silindi");
	}

	public void tabloInsert(String tabloAdi,String ... degiskenler) throws SQLException {

		String soruIsaretleri="";
		for (int i = 0; i < degiskenler.length; i++) {
			soruIsaretleri+="?,";
		}
		soruIsaretleri=soruIsaretleri.substring(0,soruIsaretleri.length()-1);
		
		PreparedStatement veri= con.prepareStatement("insert into "+tabloAdi+" values("+soruIsaretleri+")");
		
		
		for (int i = 0; i < degiskenler.length; i++) {
			veri.setString(i+1, degiskenler[i]);
		}
			veri.addBatch();		
		veri.executeBatch();		
		System.out.println("kayitlar eklendi");
	}
	
	public void tabloGoster() {

	}
	
	
	
	
	
	
	
	
	
	
}

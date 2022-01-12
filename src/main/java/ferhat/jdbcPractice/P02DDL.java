package ferhat.jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class P02DDL {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");
	 
	        Statement st = con.createStatement();
	        
	        /*=======================================================================
		  	  ORNEK1:isciler adinda bir tablo olusturunuz id int, 
		  	  birim VARCHAR(10), maas int
		  	========================================================================*/ 
	        
//	        st.execute("Create table isciler "
//	        		+ "( id int primary key,"
//	        		+ " birim varchar(10),"
//	        		+ " maas int)");
//	
//	        System.out.println("tablo oluşturuldu");
	        
	        /*======================================================================
			  ORNEK2:isciler tablosunu siliniz 		
			========================================================================*/

//	        st.execute("Drop table isciler");
//	        System.out.println("işçiler tablosu silindi");
	        
	        
	        /*=======================================================================
			  ORNEK3:isciler tablosuna yeni bir sutun {isim Varchar(20)} ekleyiniz.   
			========================================================================*/
	       try {
			st.execute("alter table isciler add isim varchar(20)");
			System.out.println("sutun eklendi");
		} catch (Exception e) {
			e.getMessage();
		}
	        
	        /*=======================================================================
			  ORNEK4:isciler tablosuna soyisim VARCHAR(20) ve sehir VARCHAR(10)) 
			  adinda 2 yeni sutun ekleyiniz.  
			========================================================================*/
	        try {
				st.execute("alter table isciler add (soyisim varchar(20),sehir varchar(10))");
				System.out.println("islem tamam");
			} catch (Exception e) {
				e.getMessage();
			}
	        
	        /*=======================================================================
			  ORNEK5:isciler tablosundaki soyisim sutunu siliniz.
			========================================================================*/ 
	        try {
				st.execute("alter table isciler drop column soyisim");
				System.out.println("sutun silindi");
			} catch (Exception e) {
				e.getMessage();
			}
	        
	        ResultSet veri=st.executeQuery("select sehir from isciler");
	        
	        while (veri.next()) {
				System.out.println(veri.getString(1));
				
			}
	        
	        /*=======================================================================
			  ORNEK6:isciler tablosunun adini calisanlar olarak degistiriniz.  
			========================================================================*/
	        try {
				st.execute("alter table isciler rename to calisanlar");
				System.out.println("isim değiştirildi");
			} catch (Exception e) {
				e.getMessage();
			}
	        
	        /*=======================================================================
			  ORNEK7:calisanlar tablosunu siliniz.  
			========================================================================*/
	        
			String dropQuery2 = "DROP TABLE calisanlar5 ";
			st.execute(dropQuery2);	
			System.out.println("calisanlar tablosu silindi..");
			
			 con.close();
		        st.close();
		        st.close();
	        
	      
	        
	}

}

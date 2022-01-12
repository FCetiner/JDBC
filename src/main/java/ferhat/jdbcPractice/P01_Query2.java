package ferhat.jdbcPractice;

import java.sql.*;

public class P01_Query2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
	
	       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");
	 
	        Statement st = con.createStatement();
	        /*=======================================================================
//			 ORNEK1: Bolumler tablosundaki tum kayitlari listeleyen bir sorgu yaziniz.
//			========================================================================*/ 
	        
	       ResultSet veri= st.executeQuery("select * from bolumler");

	       while (veri.next()) {
			System.out.println("Bolum id : " + veri.getInt(1) + " Bölüm ismi : " + veri.getString(2)+ " Konum : " + veri.getString(3));
		}
	       
	       System.out.println("*****************************************");
	       
	   	/*=======================================================================
	 		ORNEK2: SATIS ve MUHASEBE bolumlerinde calisan personelin isimlerini ve 
	  		 maaslarini, maas ters sirali olarak listeleyiniz
		========================================================================*/
	       
	       ResultSet veri2= st.executeQuery("select isim, maas from personel order by maas desc");
	       
	       while (veri2.next()) {
			System.out.println("isim :"+veri2.getString(1)+"\t"+ "maas : "+veri2.getString(2));
		}
	       
	       System.out.println("=====================================");
			
		   /*=======================================================================
			  ORNEK3: Tüm bolumlerde calisan personelin isimlerini, bolum isimlerini 
			  ve maaslarini, bolum ve maas sirali listeleyiniz. NOT: calisani olmasa 
			  bile bolum ismi gosterilmelidir.
			========================================================================*/ 
	       ResultSet veri3=st.executeQuery("select b.bolum_isim,p.isim,p.maas from bolumler b left join personel p "
	    		   + " on p.bolum_id=b.bolum_id "
	    		   + " order by b.bolum_isim,p.maas");
	       
	       while (veri3.next()) {
			System.out.println(veri3.getString(1)+"\t\t" +veri3.getString(2)+"\t\t"+veri3.getInt(3));
		}
	       
	       System.out.println("=====================================");
		   
	 	  /*=======================================================================
	 	  ORNEK4: Maasi en yuksek 10 kisinin bolumunu,adini ve maasini listeyiniz
	 	========================================================================*/ 
	       ResultSet veri4=st.executeQuery("select p.isim,b.bolum_isim,p.maas from personel p left join bolumler b "
	       		+ " on p.bolum_id=b.bolum_id "
	       		+ " order by p.maas desc"
	       		+ " limit 10");
	       
	       con.close();
	       st.close();
	       veri.close();
	       veri2.close();
	       veri3.close();
	       veri4.close();
	       
	}

}

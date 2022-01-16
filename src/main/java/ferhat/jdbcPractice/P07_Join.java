package ferhat.jdbcPractice;

import java.sql.*;

public class P07_Join {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");
	    Statement st = con.createStatement();

	    
	    /* -----------------------------------------------------------------------------
	    ORNEK1: Iki Tabloda sirket_id'si ayni olanlarin sirket_ismi, siparis_id ve 
	    siparis_tarihleri listeleyen bir sorgu yaziniz.
	  ------------------------------------------------------------------------------*/ 
	    String sorgu="select sir.sirket_isim,sip.sirket_id,sip.siparis_tarihi,sip.sirket_id "
	    		+ " from sirketler sir"
	    		+ " INNER JOIN siparisler sip"
	    		+ " ON sir.sirket_id=sip.sirket_id;";
	    
	   ResultSet sonuc= st.executeQuery(sorgu);
	    
	    while (sonuc.next()) {
			System.out.println(sonuc.getString(1)+" "+sonuc.getInt(2)+" "+sonuc.getString(3)+" "+sonuc.getInt(4));
		}
	  
	    System.out.println("=====================================");
	    
	    /* -----------------------------------------------------------------------------
	    ORNEK2: sirketler tablosundaki tum sirketleri ve bu sirketlere ait olan 
	    siparis_id ve siparis_tarihleri listeleyen bir sorgu yaziniz.
	  ------------------------------------------------------------------------------*/
	    String sorgu2="select sir.sirket_id, sip.siparisler,sip.siparis_tarihi "
	    		+ "  from sirketler sir left join siparisler sip"
	    		+ " on sir.sirket_id=sip.sirket_id;";
	    
	   ResultSet sonuc2= st.executeQuery(sorgu);
	    
	    while (sonuc2.next()) {
			System.out.println(sonuc2.getString(1)+" "+sonuc2.getInt(2)+" "+sonuc2.getString(3)+" "+sonuc2.getInt(4));
		}
	  
	    System.out.println("=====================================");
	    
	    /* -----------------------------------------------------------------------------
	    ORNEK1: SATIS ve MUHASABE bolumlerinde calisan personelin isimlerini ve 
	    bolumlerini, once bolum sonra isim sıralı olarak listeleyiniz
	  ------------------------------------------------------------------------------*/
	    
	    String sorgu3="select p.personel_isim, b.bolum_isim "
	    		+ " from personel p join bolumler b "
	    		+ " on p.bolum_id= b.bolum_id "
	    		+ " where b.bolum_isim in(Satis,Muhasebe)"
	    		+ " b.bolum_isim p.personel_isim";
	    
	   ResultSet sonuc3= st.executeQuery(sorgu);
	    
	    while (sonuc3.next()) {
			System.out.println(sonuc3.getString(1)+" "+sonuc3.getInt(2)+" "+sonuc3.getString(3)+" "+sonuc3.getInt(4));
		}
	  
	    System.out.println("=====================================");
	}

}

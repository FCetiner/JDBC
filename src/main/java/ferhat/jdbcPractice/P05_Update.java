package ferhat.jdbcPractice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class P05_Update {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");
	Statement st= con.createStatement();
	
	
	// execute=>false dondurur
	//executeUpdate=> int 1 dondurur
	//executeQuery =>sorgu yapar	döngü ile yazdırabiliriz
	
	//1)tedarikciler ve ürünler tablosu oluşturalım
//	try {
//		st.execute("CREATE TABLE tedarikciler (vergiNo int PRIMARY KEY,"
//			+ " firma_ismi VARCHAR(50),"
//			+ " irtibat_ismi VARCHAR(50));");
//	System.out.println("Tablo oluşturuldu");
//	} catch (Exception e) {
//		e.getMessage();
//	}
	
	
//		st.execute("CREATE TABLE urunler( ted_vergino int,"
//			+ " urun_id int,"
//			+ " urun_isim VARCHAR(50),"
//			+ " musteri_isim VARCHAR(50),"
//			+ " CONSTRAINT fk_urunler FOREIGN KEY(ted_vergino) REFERENCES tedarikciler(vergiNo)"
//			+ " on delete cascade);");
//	System.out.println("Tablo oluşturuldu");
	
	//Veri girişlerini yapalım 3 YOLU VARDI 
	//ilki tek tek girmek
	//2)Verileri bir arraya doldurup AddBatch(), execute..
	//3)Insert into ? ? => adbatch kullanmak ilkini birinci yöntemle ekleyelim
	
	//First way	executeUpdate kullanmak daha yaygın
//	st.execute("INSERT INTO tedarikciler VALUES (101, 'IBM', 'Kim Yon');");
//	System.out.println("Veri girişi yapıldı");
	
	//Second way
	
//	String veriler[]= { "INSERT INTO tedarikciler VALUES (102, 'Huawei', 'Çin Li');",
//    "INSERT INTO tedarikciler VALUES (103, 'Erikson', 'Maki Tammamen');",
//    "INSERT INTO tedarikciler VALUES (104, 'Apple', 'Adam Eve');"};
//	
//	for (String each : veriler) {
//		st.addBatch(each);
//	}
//	st.executeBatch();
//	System.out.println("Veriler eklendi");
	
	//tedarikciler veri girişi tamamlandır şimdi sorgu yapalım
	
//	ResultSet veri= st.executeQuery("SELECT * FROM tedarikciler");
//	while (veri.next()) {
//		System.out.println(veri.getInt(1)+" "+veri.getString(2)+" "+veri.getString(3));
//	}
	
	//geçelim ürünlere
//	List<Urunler>veriler=new ArrayList<>();
//	veriler.add(new Urunler(101, 1001,"Laptop", "Ayşe Can"));
//	veriler.add(new Urunler(102, 1002,"Phone", "Fatma Aka"));
//	veriler.add(new Urunler(102, 1003,"TV", "Ramazan Öz"));
//	veriler.add(new Urunler(102, 1004,"Laptop", "Veli Han"));
//	veriler.add(new Urunler(103, 1005,"Phone", "Canan Ak"));
//	veriler.add(new Urunler(104, 1006,"TV", "Ali Bak"));
//	veriler.add(new Urunler(104, 1007,"Phone", "Aslan Yılmaz"));
//	
//	PreparedStatement veri=con.prepareStatement("insert into urunler values(?,?,?,?)");
//	
//    for (Urunler each : veriler) {
//		veri.setInt(1, each.getTed_vergino());
//		veri.setInt(2, each.getUrun_id());
//		veri.setString(3, each.getUrun_isim());
//		veri.setString(4, each.getMusteri_isim());
//		veri.addBatch();
//	}
//    veri.executeBatch();
//    System.out.println("Veriler güncellendi");

//	ResultSet veri= st.executeQuery("SELECT * FROM urunler");
//	while (veri.next()) {
//		System.out.println(veri.getInt(1)+" "+veri.getInt(2)+" "+veri.getString(3)+" "+veri.getString(4));
//	}

	/* -----------------------------------------------------------------------------
	  ORNEK1: vergi_no’su 102 olan tedarikcinin (firma) ismini 'Vestel' olarak güncelleyeniz. 
	 -----------------------------------------------------------------------------*/ 
//	String update="update tedarikciler set firma_ismi='Vestel' where vergiNo=102";
//	int sayı=st.executeUpdate(update);
//	 System.out.println(sayı + " adet veri güncellendi");
	   
	/* -----------------------------------------------------------------------------
	  ORNEK2: Tedarikciler tablosundaki tüm firma isimlerini 'CASPER' olarak 
	  güncelleyeniz. 
	 -----------------------------------------------------------------------------*/ 
//	 String update="update tedarikciler set firma_ismi='CASPER'";
//		int sayı=st.executeUpdate(update);
//		 System.out.println(sayı + " adet veri güncellendi");
	  
	    
	/* -----------------------------------------------------------------------------
	  ORNEK3: vergi_no’su 101 olan tedarikcinin ismini 'casper' ve irtibat_ismi’ni 
	  'Ali Veli' olarak güncelleyiniz. 
	 -----------------------------------------------------------------------------*/ 
//		 String update="update tedarikciler set firma_ismi='casper',irtibat_ismi='Ali Veli' WHERE vergiNo=101";
//			int sayı=st.executeUpdate(update);
//			 System.out.println(sayı + " adet veri güncellendi");
	    
	/* -----------------------------------------------------------------------------
	  ORNEK4: firma_ismi casper olan tedarikcinin irtibat_ismini 'İpek Bilgin' 
	  olarak güncelleyiniz.
	 -----------------------------------------------------------------------------*/ 
//		String update="update tedarikciler set irtibat_ismi='ipek Bilgin' WHERE firma_ismi='casper'";
//		int sayı=st.executeUpdate(update);
//		System.out.println(sayı + " adet veri güncellendi");
	/* -----------------------------------------------------------------------------
	  ORNEK5: urunler tablosundaki 'Phone' değerlerini Telefon olarak güncelleyiniz.
	 -----------------------------------------------------------------------------*/
//		String update="update urunler set urun_isim='Telefon' WHERE urun_isim='Phone'";
//		int sayı=st.executeUpdate(update);
//		System.out.println(sayı + " adet veri güncellendi");
	 
	/* -----------------------------------------------------------------------------
	  ORNEK6: urunler tablosundaki urun_id değeri 1004'ten büyük olanların urun_id
	  değerlerini bir arttırınız
	 -----------------------------------------------------------------------------*/ 
//	String update="update urunler set urun_id=urun_id+1 WHERE urun_id>1004";
//	int sayı=st.executeUpdate(update);
//	System.out.println(sayı + " adet veri güncellendi");
	  
	 /* ----------------------------------------------------------------------------
	  ORNEK7: urunler tablosundaki tüm ürünlerin urun_id değerini ted_vergino 
	  sutun değerleri ile toplayarak güncelleyiniz.
	 -----------------------------------------------------------------------------*/  
//	String update="update urunler set urun_id=urun_id+ted_vergino ;";
//	int sayı=st.executeUpdate(update);
//	System.out.println(sayı + " adet veri güncellendi");
	
//	 tedarikcilerin insertini tekrar yapıyoruz
//	st.execute("DELETE FROM tedarikciler;");
//	System.out.println("veriler silindi");
	    
	/*-----------------------------------------------------------------------------
	 ORNEK8: urunler tablosundan Ali Bak’in aldigi urunun ismini, tedarikci 
	 tablosunda irtibat_ismi 'Adam Eve' olan firmanın ismi (firma_ismi) ile 
	 degistiriniz.
	 -----------------------------------------------------------------------------*/
//	String update="update urunler set urun_isim=(select firma_ismi from tedarikciler where irtibat_ismi='Adam Eve') where musteri_isim='Ali Bak';";
//	int sayı=st.executeUpdate(update);
//	System.out.println(sayı + " adet veri güncellendi");
	
	/*------------------------------------------------------------------------------
	 ORNEK9: Laptop satin alan musterilerin ismini, Apple’in irtibat_isim'i ile 
	 degistirin
	 -----------------------------------------------------------------------------*/
//	String update="update urunler set musteri_isim=(select irtibat_ismi from tedarikciler where firma_ismi='Apple') where urun_isim='laptop';";
//	int sayı=st.executeUpdate(update);
//	System.out.println(sayı + " adet veri güncellendi");
}
}

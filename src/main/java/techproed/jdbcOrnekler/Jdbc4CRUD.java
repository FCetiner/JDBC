package techproed.jdbcOrnekler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Jdbc4CRUD {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root",
				"1234");

		Statement st = con.createStatement();

		/*
		 * =======================================================================
		 * ORNEK1: urunler adinda bir tablo olusturalim id int, isim VARCHAR(10) fiyat
		 * int ========================================================================
		 */

		st.execute("CREATE TABLE urunler(" + " id int," + " isim VARCHAR(10)," + " fiyat double)");
		System.out.println("Tablo oluşturuldu");

		/*
		 * ======================================================================= //
		 * ORNEK2: urunler tablosuna asagidaki kayitlari toplu bir sekilde ekleyelim //
		 * ========================================================================
		 */
		// Cok miktarda kayit eklemek icin PreparedStatement metodu kullanilabilir.
		// PreparedStatement hem hizli hem de daha guvenli (SQL injection saldirilari
		// icin) bir yontemdir.
		// Bunun icin;
		// 1) Veri girisine uygun bir POJO(Plain Old Java Object) sinifi olusturulur.
		// 2) POJO Class nesnelerini saklayacak bir collection olusturulur
		// 3) bir dongu ile kayitlar eklenir.

		List<Urun> kayitlar = new ArrayList<>();

		kayitlar.add(new Urun(101, "laptop", 6500));
		kayitlar.add(new Urun(102, "PC", 4500));
		kayitlar.add(new Urun(103, "Telefon", 4500));
		kayitlar.add(new Urun(104, "Anakart", 1500));
		kayitlar.add(new Urun(105, "Klavye", 200));
		kayitlar.add(new Urun(106, "Fare", 100));

		con.prepareStatement("insert into urunler values(?,?,?)");
		
		
		
		
		
	}

}

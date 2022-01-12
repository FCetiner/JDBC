package ferhat.jdbcPractice;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import techproed.jdbcOrnekler.Urun;
@SuppressWarnings("unused")
public class P04CRUD {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root",
				"1234");
		Statement st= con.createStatement();
		
		
		/*
		 * =======================================================================
		 * ORNEK1: urunler adinda bir tablo olusturalim id int, isim VARCHAR(10) fiyat
		 * int ========================================================================
		 */
		try {
		st.execute("CREATE TABLE urunler(" + " id int," + " isim VARCHAR(10)," + " fiyat double)"); // execute false dondurur
					System.out.println("Urunler tablosu oluşturuldu");	
		} catch (Exception e) {
			e.getMessage();
		}
		
		/*
		 * ======================================================================= //
		 * ORNEK2: urunler tablosuna asagidaki kayitlari toplu bir sekilde ekleyelim //
		 * ========================================================================
		 */
//		
//		List<Urun> kayitlar=new ArrayList<>();
//		kayitlar.add(new Urun(101, "laptop", 6500));
//		kayitlar.add(new Urun(102, "PC", 4500));
//		kayitlar.add(new Urun(103, "Telefon", 4500));
//		kayitlar.add(new Urun(104, "Anakart", 1500));
//		kayitlar.add(new Urun(105, "Klavye", 200));
//		kayitlar.add(new Urun(106, "Fare", 100));
//		
//		PreparedStatement veri=con.prepareStatement("Insert into urunler values(?,?,?)");
//		
//		
//			int count3=0;
//			for (Urun each : kayitlar) {
//				veri.setInt(1,each.getId());
//				veri.setString(2,each.getIsim());
//				veri.setDouble(3, each.getFiyat());
//				veri.addBatch();
//				count3++;
//			}
//			System.out.println(count3 + " adet veri girişi yapıldı");
		

		
		// ürünler tablosundaki PC nin fiyatini %10 zam yapınız
		
//		st.executeUpdate("update urunler set fiyat=fiyat*1.1 where isim='PC'");
//		System.out.println("Pc fiyatı guncellendi");
	
		/*=======================================================================
		  ORNEK4: urunler tablosuna Marka adinda ve Default degeri ASUS olan yeni 
		  bir sutun ekleyiniz.
		========================================================================*/
		
		int adet=st.executeUpdate("alter table urunler add Marka varchar (20) default 'ASUS'");
		System.out.println(adet+" sutun eklendi");
	
		/*=======================================================================
		  ORNEK5: urunler tablosunu siliniz.
		========================================================================*/
//		st.execute("drop table urunler");
//		System.out.println("tablo silindi");
		
		st.close();
		con.close();
	
	}

}

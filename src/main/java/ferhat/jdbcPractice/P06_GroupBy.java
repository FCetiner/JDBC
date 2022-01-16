package ferhat.jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class P06_GroupBy {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root",
				"1234");
		Statement st = con.createStatement();

		/*
		 * -----------------------------------------------------------------------------
		 * ORNEK1: kisi ismine göre satılan toplam meyve miktarlarını gösteren sorguyu
		 * yazınız.
		 * -----------------------------------------------------------------------------
		 * -
		 */
//		String sorgu="Select isim,sum(urun_miktari)as toplam_urun from manav group by isim;";
//			ResultSet sonuc=st.executeQuery(sorgu);
//				while (sonuc.next()) {
//					System.out.println(sonuc.getString(1)+" "+sonuc.getInt(2));
//				}
//		    
		/*
		 * ----------------------------------------------------------------------------
		 * ORNEK2: satılan meyve türüne (urun_adi) göre urun alan kişi sayısını gösteren
		 * sorguyu yazınız. NULL olarak girilen meyveyi listelemesin.
		 * -----------------------------------------------------------------------------
		 */
//		String sorgu = "Select urun_adi,count(isim)as adet from manav where urun_adi is not null group by urun_adi;";
//		ResultSet sonuc = st.executeQuery(sorgu);
//		
//		while (sonuc.next()) {
//			System.out.println(sonuc.getString(1) + " " + sonuc.getInt(2));
//		}

		/*
		 * ----------------------------------------------------------------------------
		 * ORNEK3: satılan meyve türüne (urun_adi) göre satılan (urun_miktari )MIN ve
		 * MAX urun miktarlarini, MAX urun miktarina göre sıralayarak listeyen sorguyu
		 * yazınız.
		 * -----------------------------------------------------------------------------
		 */
//		String sorgu = "Select urun_adi,min(urun_miktari)min,max(urun_miktari)max from manav where urun_adi is not null group by"
//				+ " urun_adi  order by max(urun_miktari);";
//		ResultSet sonuc = st.executeQuery(sorgu);
//		
//		while (sonuc.next()) {
//			System.out.println(sonuc.getString(1) + " " + sonuc.getInt(2)+ " " + sonuc.getInt(3));
//		}
		/*
		 * ----------------------------------------------------------------------------
		 * ORNEK4: kisi ismine ve urun adına göre satılan ürünlerin toplamını
		 * gruplandıran ve isime göre ters sırasıda listeyen sorguyu yazınız.
		 * -----------------------------------------------------------------------------
		 */
//		String sorgu = "Select isim,sum(urun_miktari)sum from manav where urun_adi is not null group by"
//				+ " isim, urun_adi order by isim desc;";
//		ResultSet sonuc = st.executeQuery(sorgu);
//		
//		while (sonuc.next()) {
//			System.out.println(sonuc.getString(1) + " " + sonuc.getInt(2));
//		}
		
		/*
		 * ----------------------------------------------------------------------------
		 * ORNEK5: kisi ismine ve urun adına göre (gruplayarak) satılan ürünlerin
		 * toplamını bulan ve ve bu toplam değeri 3 ve fazlası olan kayıtları toplam
		 * urun miktarlarina göre ters siralayarak listeyen sorguyu yazınız.
		 * -----------------------------------------------------------------------------
		 */
//		String sorgu = " select isim, urun_adi, sum(urun_miktari)"
//				+ "		 from manav"
//				+ "		 group by isim, urun_adi"
//				+ "		 having sum(urun_miktari)>=3 "
//				+ "		 order by sum(urun_miktari) desc;";
//		ResultSet sonuc = st.executeQuery(sorgu);
//		
//		while (sonuc.next()) {
//			System.out.println(sonuc.getString(1) + " " +sonuc.getString(2) + " " + sonuc.getInt(3));
//		}

		
		/*
		 * ----------------------------------------------------------------------------
		 * ORNEK6: satılan urun_adi'na göre (gruplayarak) MAX urun sayılarını
		 * sıralayarak listeleyen sorguyu yazınız. NOT: Sorgu, sadece MAKS urun_miktari
		 * MIN urun_miktarına eşit olmayan kayıtları listelemelidir.
		 * -----------------------------------------------------------------------------
		 */
//		String sorgu = "  select urun_adi, max(urun_miktari)max"
//				+ " from manav"
//				+ " group by urun_adi"
//				+ " having max!=min(urun_miktari)"
//				+ " order by max;";
//		ResultSet sonuc = st.executeQuery(sorgu);
//		
//		while (sonuc.next()) {
//			System.out.println(sonuc.getString(1) + " " +sonuc.getInt(2));
//		}

		 
		/*
		 * ----------------------------------------------------------------------------
		 * ORNEK1: satılan farklı meyve türlerinin sayısını listeleyen sorguyu yazınız.
		 * -----------------------------------------------------------------------------
		 */
//		String sorgu = "  select distinct urun_adi,  count(distinct(urun_adi))"
//				+ " from manav";
//				
//		ResultSet sonuc = st.executeQuery(sorgu);
//		
//		while (sonuc.next()) {
//			System.out.println(sonuc.getString(1) + " " +sonuc.getInt(2));
//		}
		
		/*
		 * -----------------------------------------------------------------------------
		 * ORNEK2: satılan meyve + isimlerin farklı olanlarını listeyen sorguyu yazınız.
		 * -----------------------------------------------------------------------------
		 * -
		 */
//		String sorgu = "  select distinct urun_adi, isim"
//				+ " from manav";
//				
//		ResultSet sonuc = st.executeQuery(sorgu);
//		
//		while (sonuc.next()) {
//			System.out.println(sonuc.getString(1) + " " +sonuc.getString(2));
//		}
		/*
		 * ----------------------------------------------------------------------------
		 * ORNEK3: satılan meyvelerin urun_mikarlarinin benzersiz olanlarının
		 * toplamlarini listeyen sorguyu yazınız.
		 * -----------------------------------------------------------------------------
		 */

		String sorgu = " select sum(distinct urun_miktari)toplam from manav;";
				
		ResultSet sonuc = st.executeQuery(sorgu);
		
		while (sonuc.next()) {
			System.out.println(sonuc.getInt(1));
		}
	}

}

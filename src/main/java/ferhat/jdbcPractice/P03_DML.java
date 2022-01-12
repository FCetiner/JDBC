package ferhat.jdbcPractice;


import java.sql.*;

public class P03_DML {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {


		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root",
				"1234");
		Statement st = con.createStatement();
		
		/*
		 * =========================================================================
		 * ORNEK1: Bolumler tablosuna yeni bir kayit (80, 'ARGE', 'ISTANBUL') ekleyelim
		 * ========================================================================
		 */
		
		try {
			int s1=st.executeUpdate("INSERT INTO bolumler VALUES (80, 'ARGE', 'ISTANBUL')" ); //executeUpdate sayı değeri döndürüyor
		System.out.println(s1+" satır eklendi");
		} catch (java.sql.SQLIntegrityConstraintViolationException e) {
			System.out.println(e.getMessage());
				}
		/*
		 * =======================================================================
		 * ORNEK2: Bolumler tablosuna birden fazla yeni kayıt ekleyelim.
		 * ========================================================================
		 */
		// 1.YONTEM
		String[] sorgular= {"INSERT INTO bolumler VALUES(95, 'YEMEKHANE', 'ISTANBUL')",
				"INSERT INTO bolumler VALUES(85, 'OFIS','ANKARA')", "INSERT INTO bolumler VALUES(75, 'OFIS2', 'VAN')"};
		
		try {
			int count=0;
		for (String each : sorgular) {
			count+=st.executeUpdate(each);
		}
				System.out.println(count+" adet veri girişi yapıldı");
		} catch (Exception e) {
			e.getMessage();
		}
		
		// 2.YONTEM (addBatch ve excuteBatch() metotlari ile)
		
		String [] sorgular2= {"INSERT INTO bolumler VALUES(81, 'YEMEKHANE2', 'MUS')",
				"INSERT INTO bolumler VALUES(82, 'OFIS3','ORDU')",
				"INSERT INTO bolumler VALUES(83, 'OFIS4', 'MUGLA')"};
		
		try {
			int count2=0;
		for (int i = 0; i < sorgular2.length; i++) {
		 st.addBatch(sorgular2[i]);
		 count2++;
		}
		st.executeBatch();
		System.out.println(count2 +" adet veri girişi yapıldı");
		} catch (Exception e) {
			e.getMessage();
		}
		
		
	}

}

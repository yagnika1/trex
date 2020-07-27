package com.ivy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryBlock {
	public static List<String> getGamesList() {
		List<String> brandList = new ArrayList<String>();
		try {
			// step1 load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=10.184.232.113)(PORT=1521)))(CONNECT_DATA=(SID=PRTYDLD2)))", "pcasino",
					"onisacp786");

			// step3 create the statement object
			Statement stmt = con.createStatement();

			String s = null;

			// step4 execute query
			ResultSet rs = stmt
					.executeQuery("select f_display_name from t_c_table_info order by f_display_name asc");
			while (rs.next()) {
				s = new String();
				s = rs.getString(1);

				brandList.add(s);
			}
			// step5 close the connection object
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return brandList;

	}
	public static List<String> getCountryNames(String d) {
		// TODO Auto-generated method stub
		List<String> brandList = new ArrayList<String>();
		try {
			// step1 load the driver class

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=10.184.232.113)(PORT=1521)))(CONNECT_DATA=(SID=PRTYDLD2)))", "pcasino",
					"onisacp786");

			// step3 create the statement object
			PreparedStatement pst = con
					.prepareStatement("select distinct f_name from sym_t_country_code s, t_c_country_blocked_games b, t_c_table_info t \r\n" + 
							"where s.f_code = b.f_country and\r\n" + 
							"b.f_table_type_id = t.f_table_type_id and\r\n" + 
							"t.f_display_name = ?");
			pst.setString(1, d);
			

			String s = null;
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				s = new String(rs.getString(1));
				// s.setTableTypeId(rs.getInt(2));

				brandList.add(s);
			}
			// step5 close the connection object
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return brandList;
	}
	public static List<String> getCountryList() {
		List<String> brandList = new ArrayList<String>();
		try {
			// step1 load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=10.184.232.113)(PORT=1521)))(CONNECT_DATA=(SID=PRTYDLD2)))", "pcasino",
					"onisacp786");

			// step3 create the statement object
			Statement stmt = con.createStatement();

			String s = null;

			// step4 execute query
			ResultSet rs = stmt
					.executeQuery("select DISTINCT(f_name) from sym_t_country_code order by f_name asc");
			while (rs.next()) {
				s = new String();
				s = rs.getString(1);

				brandList.add(s);
			}
			// step5 close the connection object
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return brandList;

	}
	public static List<String> getGameNames(String d) {
		// TODO Auto-generated method stub
		List<String> brandList = new ArrayList<String>();
		try {
			// step1 load the driver class

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=10.184.232.113)(PORT=1521)))(CONNECT_DATA=(SID=PRTYDLD2)))", "pcasino",
					"onisacp786");

			// step3 create the statement object
			PreparedStatement pst = con
					.prepareStatement("select distinct F_DISPLAY_NAME from t_c_table_info t, t_c_country_blocked_games c, sym_t_country_code s where t.f_table_type_id = c.f_table_type_id and c.f_country = s.f_code and s.f_name = ?");
			pst.setString(1, d);
			

			String s = null;
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				s = new String(rs.getString(1));
				// s.setTableTypeId(rs.getInt(2));

				brandList.add(s);
			}
			// step5 close the connection object
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return brandList;
	}
	public static List<String> getGameNames(String d,String g) {
		// TODO Auto-generated method stub
		List<String> brandList = new ArrayList<String>();
		try {
			// step1 load the driver class

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=10.184.232.113)(PORT=1521)))(CONNECT_DATA=(SID=PRTYDLD2)))", "pcasino",
					"onisacp786");

			// step3 create the statement object
			PreparedStatement pst = con
					.prepareStatement("select f_status from t_c_country_blocked_games where f_table_type_id in(select f_table_type_id  from t_c_table_info where  F_DISPLAY_NAME = ?) and f_country in(select f_code from sym_t_country_code where f_name = ?)");
			pst.setString(1, d);
			pst.setString(2, g);

			String s = null;
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				s = new String(rs.getString(1));
				// s.setTableTypeId(rs.getInt(2));

				brandList.add(s);
			}
			// step5 close the connection object
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return brandList;
	}
	public static List<String> getVendorList() {
		List<String> brandList = new ArrayList<String>();
		try {
			// step1 load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=10.184.232.113)(PORT=1521)))(CONNECT_DATA=(SID=PRTYDLD2)))", "pcasino",
					"onisacp786");

			// step3 create the statement object
			Statement stmt = con.createStatement();

			String s = null;

			// step4 execute query
			ResultSet rs = stmt
					.executeQuery("select distinct F_VENDOR_ID from T_C_VENDOR_GAME_DETAILS");
			while (rs.next()) {
				s = new String();
				s = rs.getString(1);

				brandList.add(s);
			}
			// step5 close the connection object
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return brandList;

	}
	public static List<String> getGameName(String v) {
		// TODO Auto-generated method stub
		List<String> brandList = new ArrayList<String>();
		try {
			// step1 load the driver class

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=10.184.232.113)(PORT=1521)))(CONNECT_DATA=(SID=PRTYDLD2)))", "pcasino",
					"onisacp786");

			// step3 create the statement object
			PreparedStatement pst = con
					.prepareStatement("select f_display_name from t_c_table_info t, T_C_VENDOR_GAME_DETAILS g where g.F_TABLE_TYPE_ID = t.F_TABLE_TYPE_ID and g.F_VENDOR_ID = ?");
			pst.setString(1, v);
			

			String s = null;
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				s = new String(rs.getString(1));
				// s.setTableTypeId(rs.getInt(2));

				brandList.add(s);
			}
			// step5 close the connection object
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return brandList;
	}
	public static String getEnableorDisable(String v) {
		// TODO Auto-generated method stub
		String s = null;
		try {
			// step1 load the driver class

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=10.184.232.113)(PORT=1521)))(CONNECT_DATA=(SID=PRTYDLD2)))", "pcasino",
					"onisacp786");

			// step3 create the statement object
			PreparedStatement pst = con
					.prepareStatement("select f_is_active from t_c_table_info where f_display_name like ?");
			pst.setString(1, v);
			

			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				s = new String(rs.getString(1));
				// s.setTableTypeId(rs.getInt(2));

				
			}
			// step5 close the connection object
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return s;
	}
	public static int getTabletypeid(String v) {
		// TODO Auto-generated method stub
		Integer s = 0;
		try {
			// step1 load the driver class

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=10.184.232.113)(PORT=1521)))(CONNECT_DATA=(SID=PRTYDLD2)))", "pcasino",
					"onisacp786");

			// step3 create the statement object
			PreparedStatement pst = con
					.prepareStatement("select * from t_c_table_info where f_display_name like ?");
			pst.setString(1, v);
			

			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				s = new Integer(rs.getInt(1));
				// s.setTableTypeId(rs.getInt(2));

				
			}
			// step5 close the connection object
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return s;
	}
	public static String getAgentName(int v) {
		// TODO Auto-generated method stub
		String s = null;
		try {
			// step1 load the driver class

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=10.184.232.113)(PORT=1521)))(CONNECT_DATA=(SID=PRTYDLD2)))", "pcasino",
					"onisacp786");

			// step3 create the statement object
			PreparedStatement pst = con
					.prepareStatement("select distinct b.f_update_by from t_c_table_info t, T_C_GEO_BIO_BLOCKED_GAMES_LOG b where t.f_table_type_id = ?");
			pst.setInt(1, v);
			

			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				s = new String(rs.getString(1));
				// s.setTableTypeId(rs.getInt(2));

				
			}
			// step5 close the connection object
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return s;
	}
	public static List<String> getBrandName(int v) {
		// TODO Auto-generated method stub
		List<String> brandList = new ArrayList<String>();
		try {
			// step1 load the driver class

			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=10.184.232.113)(PORT=1521)))(CONNECT_DATA=(SID=PRTYDLD2)))", "pcasino",
					"onisacp786");

			// step3 create the statement object
			PreparedStatement pst = con
					.prepareStatement("select distinct b.f_brand_id from t_c_table_info t, T_C_GEO_BIO_BLOCKED_GAMES_LOG b where t.f_table_type_id = ?");
			pst.setInt(1, v);
			

			String s = null;
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				s = new String(rs.getString(1));
				// s.setTableTypeId(rs.getInt(2));

				brandList.add(s);
			}
			// step5 close the connection object
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return brandList;
	}
	
	public static void main(String[] args) {
		//List<String> gamesList = CountryBlock.getVendorList();
		String s = CountryBlock.getEnableorDisable("Roulette");
		System.out.println(s);
	}
}

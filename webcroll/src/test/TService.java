package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import data.Movie_Detail_List;

public class TService {
	String url = "jdbc:mysql://13.125.166.164:3306/P_Project";
	String root = "zoe";
	String pw = "woojin7929!M";
	String driver = "com.mysql.jdbc.Driver";

	public int test(String test) {
		int result = 0;
		String sql = "insert into test (test) values(?)";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, root, pw);
			PreparedStatement psmt = con.prepareStatement(sql);

	
			

				psmt.setString(1, test);
			result	= psmt.executeUpdate();
				
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}

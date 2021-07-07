package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import data.Cgv_code;

public class CGV_service {
	String url = "jdbc:mysql://13.124.135.97:3306/CINEMA?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String root = "cinema_pm";
	String pw = "cinema1234";
	String driver = "com.mysql.jdbc.Driver";

	public void insertdata(String areacode, String theatercode, String date,
			String movie_title, String movie_genre, String movie_runtime, String movie_release ,int movie_age_num, String movie_status,
			String hall_screen, String hall_place, String hall_seat
			,String movie_cd, String movie_cd_group, String play_ymd, String theater_cd, String play_start_tm, String area_cd, String screen_cd
			,int seatleft_num) {// daily_temp input

		String sql = " insert into cgv_daily_temp (CINEMA_CD, LOC_CD, CLOC_CD, MOVIE_CD, MOVIE_NM, MOVIE_GRPCD, START_YMD, START_TIME, RATING, GENRE, SCREEN, SEAT, SCREEN_CD) " + " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, root, pw);
			PreparedStatement psmt = con.prepareStatement(sql);

			psmt.setString(1, areacode);
			psmt.setString(2, theatercode);
			psmt.setString(3, area_cd);
			psmt.setString(4, movie_cd);
			psmt.setString(5, movie_title);
			psmt.setString(6, movie_cd_group);
			psmt.setString(7, play_ymd);
			psmt.setString(8, play_start_tm);
			psmt.setInt(9, movie_age_num);
			psmt.setString(10, movie_genre);
			psmt.setString(11, hall_screen);
			psmt.setInt(12, seatleft_num);
			psmt.setString(13, screen_cd);
			
			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void insertdata(String areacode, String theatercode, String date,
			String movie_title, String movie_genre, String movie_runtime, String movie_release ,int movie_age_num, String movie_status,
			String hall_screen, String hall_place, String hall_seat
			) {// daily_temp input 준비중

		String sql = " insert into cgv_daily_temp (CINEMA_CD, LOC_CD, MOVIE_NM,RATING, GENRE, SCREEN) " + " values(?,?,?,?,?,?)";

		try {
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, root, pw);
			PreparedStatement psmt = con.prepareStatement(sql);

			psmt.setString(1, areacode);
			psmt.setString(2, theatercode);
			psmt.setString(3, movie_title);
			psmt.setInt(4, movie_age_num);
			psmt.setString(5, movie_genre);
			psmt.setString(6, hall_screen);
			
			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public ArrayList<String> getareacode() {// areacode get

		String sql = "select distinct area_cd from cgv_parameter";
		ArrayList<String> areacode = new ArrayList<String>();
		try {
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, root, pw);
			PreparedStatement psmt = con.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				areacode.add(rs.getString("area_cd"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return areacode;
	}
	
	public ArrayList<String> gettheathercode(String areacode) {// theathercode get

		String sql = "SELECT * FROM cgv_parameter where area_cd='"+areacode+"'";
		ArrayList<String> theathercode = new ArrayList<String>();
		try {
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, root, pw);
			PreparedStatement psmt = con.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				theathercode.add(rs.getString("theater_cd"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return theathercode;
	}
	
//	public void insertpara() {// 글쓰기
//		Cgv_code c = new Cgv_code();
//		String sql = " insert into cgv_parameter (area_cd,theater_cd) " + " values(?,?)";
//
//		try {
//			
//			Class.forName(driver);
//			Connection con = DriverManager.getConnection(url, root, pw);
//			PreparedStatement psmt = con.prepareStatement(sql);
//
//			for(int i=0; i<c.getTheatercode9().length; i++) {
//				psmt.setString(1, c.getAreacode()[8]);
//				psmt.setString(2, c.getTheatercode9()[i]);
//				psmt.addBatch();
//			}
//			
//			psmt.executeBatch();
//			psmt.close();
//			System.out.println("입력완료");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
}

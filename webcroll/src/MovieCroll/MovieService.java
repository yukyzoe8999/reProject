package MovieCroll;

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

public class MovieService {
	String url = "jdbc:mysql://13.124.135.97:3306/CINEMA?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String root = "cinema_pm";
	String pw = "cinema1234";
	String driver = "com.mysql.jdbc.Driver";

	public int updateMember() { // 수정할 값을 db에 반영하는 메소드
		int result = 0;
		String sql = "update member set STATUS=? " + "  where id =?";

		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, root, pw);
			PreparedStatement psmt = con.prepareStatement(sql);

			result = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void Movie_Main_Insert(Movie_Detail_List list) {
		int result = 0;
		String sql = "insert into Movie_contents (Detail_code,Main_title,Main_rate,Main_freeEgg,Main_date,Movie_imgPath, number) values(?,?,?,?,?,?,?)";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, root, pw);
			PreparedStatement psmt = con.prepareStatement(sql);

			int size =list.getTitle_list().size();
			for(int i =0; i<size; i++) {
				psmt.setInt(1, list.getDetail_cd().get(i));
				psmt.setString(2, list.getTitle_list().get(i));
				psmt.setDouble(3, list.getRate_list().get(i));
				psmt.setString(4, list.getFreeegg_list().get(i));
				psmt.setString(5, list.getDate_list().get(i));
				psmt.setString(6, list.getMovie_imgPath().get(i));
				psmt.setInt(7, list.getNumber());
				psmt.addBatch();
			}
			
			psmt.executeBatch();
			psmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}


	}
	public void Movie_Detail_Insert(Movie_Detail_List list) {
		int result = 0;
		String sql = "insert into Movie_detail (Movie_detailCD, Detail_status,Detail_title,Detail_rate,Detail_freeEgg,Movie_spec,Movie_info) values(?,?,?,?,?,?,?)";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, root, pw);
			PreparedStatement psmt = con.prepareStatement(sql);
			System.out.println(psmt);

			int size =list.getDetail_title_list().size(); //////////////////// Detail_cd size
			System.out.println(size);
			for(int i =0; i<size; i++) {
				int DetailCD = list.getDetail_cd().get(i);
				String status = list.getStatus_list().get(i);
				String title = list.getDetail_title_list().get(i);
				String rate = list.getDetail_rate_list().get(i);
				String freeEagg = list.getDetail_freeegg_list().get(i);
				String spec = list.getMovie_spec_list().get(i);
				String info = list.getMovie_info_list().get(i);
				
				//System.out.println("프리에그 : "+ freeEagg);
				//System.out.println("예매율 : "+rate);
				//System.out.println("감독상세 : "+spec);
				
				psmt.setInt(1, DetailCD);
				psmt.setString(2, status);
				psmt.setString(3, title);
				psmt.setString(4, rate);
				psmt.setString(5, freeEagg);
				psmt.setString(6, spec);
				psmt.setString(7, info);

				psmt.addBatch();
			}
			
		 psmt.executeBatch();


		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}

package movie;

import java.io.IOException;
import java.sql.Connection;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Lotte2 {
	private static String URL = "https://www.lottecinema.co.kr/LCWS/Ticketing/TicketingData.aspx";
	private static String Host = "www.lottecinema.co.kr";
	private static String Origin = "https://www.lottecinema.co.kr";
	private static String Referer = "https://www.lottecinema.co.kr/NLCHS/Cinema/Detail?divisionCode=1&detailDivisionCode=101&cinemaID=2008";
	public static void main(String[] args) throws IOException {
		String divisionCode = "1";
		String detailDivisionCode = "101";
		String cinemaID ="2008";
		System.out.println(URL);
		String dic = dic();
		System.out.println(dic);
		//1. Document를 가져온다.
		String str = Jsoup.connect(URL)
			    .header("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundarykD5PER7C2GeWApWY")
			    .header("Accept", "application/json, text/plain, */*")
			    .header("Accept-Encoding", "gzip, deflate, br")
			    .header("Host", Host)
			    .header("Origin", Origin)
			    .header("Referer", Referer)
			    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.150 Safari/537.36")
			    .method(Method.POST)
			    .ignoreContentType(true)
			    .data("ParamList",dic)
			    .execute().body();
		
//		.data("MethodName","GetPlaySequence")
//		.data("channelType","HO")
//		.data("osType","W")
//		.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.150 Safari/537.36")
//		.data("playDate","2021-02-13")
//		.data("cinemaID","1|101|2008")
//		.data("representationMovieCode","")
		
		
		//2. 목록을 가져온다.
		System.out.println("" + str.toString());
		
//		Elements elements = doc.select(".contents");
//
//		//3. 목록(배열)에서 정보를 가져온다.
//		int idx = 0;
//		for(Element element : elements) {
//			System.out.println(++idx+" : "+ element.text());
//			System.out.println("----------------------------------");
//		}
	}
	
//	/**
//	 * URL 완성
//	 * @param areacode
//	 * @param theatercode
//	 * @param date
//	 * @return
//	 */
//	
//	public static String getParameter(String divisionCode, String detailDivisionCode, String cinemaID) {
//		String params = "divisionCode="+divisionCode
//				+ "&detailDivisionCode="+detailDivisionCode
//				+ "&cinemaID="+cinemaID;
//				
//		return params;
//	}
	public static String dic() {
		String dic = 
		        "MethodName:GetPlaySequence,"
		        +"channelType:HO,"
		        +"osType:W,"
		        +"osVersion:Mozilla/5.0 (Windows NT 10.0; Win64; x64) "
		        +"AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.150 Safari/537.36,"
		        +"playDate:2021-02-15,"
		        +"cinemaID:1|101|2008,"
		        +"representationMovieCode";
				
		return dic;
	}


}

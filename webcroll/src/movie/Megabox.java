package movie;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Megabox {
	private static String URL = "https://www.megabox.co.kr/on/oh/ohc/Brch/schedulePage.do";
	private static String Host = "www.megabox.co.kr";
	private static String Origin = "https://www.megabox.co.kr";
	private static String Referer = "https://www.megabox.co.kr/booking/timetable";
	private static String useragent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.150 Safari/537.36";
	public static void main(String[] args) throws IOException {
	
		System.out.println(URL);
		
		//1. Document를 가져온다.
		String str = Jsoup.connect(URL)
				.header("Host", Host)
				.header("Origin",Origin)
				.header("Referer", Referer)
				.userAgent(useragent)
				.data("brchNo","6906")
				.data("brchNo1","6906")
				.data("crtDe","20210213")
				.data("detailType","area")
				.data("firstAt","N")
				.data("masterType","brch")
				.data("playDe","20210215")
				.ignoreContentType(true)
				.execute().body();
			
		//2. 목록을 가져온다.
		System.out.println("-----------------");
		System.out.println("" + str);
		
//		Elements elements = doc.select(".contents");
//
//		//3. 목록(배열)에서 정보를 가져온다.
//		int idx = 0;
//		for(Element element : elements) {
//			System.out.println(++idx+" : "+ element.text());
//			System.out.println("----------------------------------");
//		}
	}
	
	/**
	 * URL 완성
	 * @param areacode
	 * @param theatercode
	 * @param date
	 * @return
	 */
	

}

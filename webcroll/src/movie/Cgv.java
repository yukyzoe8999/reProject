package movie;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import data.Cgv_code;
import data.Title;
import service.CGV_service;

public class Cgv {
	private static String URL = "http://www.cgv.co.kr/common/showtimes/iframeTheater.aspx?";

	public static void main(String[] args) throws IOException {
		CGV_service cs = new CGV_service();
		ArrayList<String> areacode_list = cs.getareacode();
		String areacode = new String();
		String theatercode = new String();
		String date = new String();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");

		Date time = new Date();

		String time1 = format1.format(time);
		
		for (int t = 0; t < 3; t++) {//날짜설정
			int time2 = Integer.parseInt(time1) + t;

			date = Integer.toString(time2);
			System.out.println("날짜:"+date);
			for (int a = 0; a < areacode_list.size(); a++) {
				areacode = areacode_list.get(a);
				System.out.println("지역:"+areacode);
				ArrayList<String> theatercode_list = cs.gettheathercode(areacode);
				for (int b = 0; b < theatercode_list.size(); b++) {
					theatercode = theatercode_list.get(b);
					System.out.println("관:"+theatercode);

//		System.out.println(URL + getParameter(areacode, theatercode, date));

					/* Document를 가져온다. */
					Document doc = Jsoup.connect(URL + getParameter(areacode, theatercode, date)).get();

					/* Elements에 Document에서 원하는 부분을 가져와 넣는다. */
					Elements title = doc.select(".sect-showtimes").select("ul").select("li").select(".info-movie")
							.select("strong");// 제목
//		

					/* 영화정보 data저장 */
					String movie_title = new String();
					String movie_age = new String();
					int movie_age_num;
					String movie_genre = new String();
					String movie_release = new String();
					String movie_runtime = new String();
					String movie_status = new String();
					/* 관정보 data저장 */
					String hall_screen = new String();
					String hall_place = new String();
					String hall_seat = new String();
					/**/
					String seatleft_str = new String();
					int seatleft_num;
					

					for (int i = 1; i <= title.size(); i++) {
						System.out.println(title.get(i - 1).text());
						/* 영화정보 */
						Elements genre = doc.select("body > div > div.sect-showtimes > ul > li:nth-child(" + i
								+ ") > div > div.info-movie > i:nth-child(5)");// 장르
						Elements runtime = doc.select("body > div > div.sect-showtimes > ul > li:nth-child(" + i
								+ ") > div > div.info-movie > i:nth-child(6)");// 런타임
						Elements release = doc.select("body > div > div.sect-showtimes > ul > li:nth-child(" + i
								+ ") > div > div.info-movie > i:nth-child(7)");// 개봉일자
						Elements age_screnning = doc.select("body > div > div.sect-showtimes > ul > li:nth-child(" + i
								+ ") > div > div.info-movie > span");// 연령&상영중

						System.out.println(genre.text());
						System.out.println(runtime.text());
						System.out.println(release.text());
						System.out.println(age_screnning.text());
						movie_title = title.get(i - 1).text();
						movie_genre = genre.text();
						movie_runtime = runtime.text();
						movie_release = release.text();
						movie_age = age_screnning.get(0).text();
						if(movie_age.equals("전체")) {
							movie_age_num = 1;
						}else if(movie_age.equals("12세 이상")) {
							movie_age_num = 2;
						}else if(movie_age.equals("15세 이상")) {
							movie_age_num = 3;
						}else if(movie_age.equals("청소년 관람불가")) {
							movie_age_num = 4;
						}else if(movie_age.equals("미정")) {
							movie_age_num = 6;
						}else {//제한상영가
							movie_age_num = 5;
						}
						movie_status = age_screnning.get(1).text();

						Elements place = doc.select("body > div > div.sect-showtimes > ul > li:nth-child(" + i
								+ ") > div > div.type-hall > div.info-hall > ul > li:nth-child(2)");// 영화관명 밑에 for문을
																									// 돌리기위한 count를 세기위해
																									// 필요

						/* 관정보 */
						for (int j = 2; j < 2 + place.size(); j++) {

							Elements screen = doc.select("body > div > div.sect-showtimes > ul > li:nth-child(" + i
									+ ") > div > div:nth-child(" + j + ") > div.info-hall > ul > li:nth-child(1)");// 스크린종류
							Elements place2 = doc.select("body > div > div.sect-showtimes > ul > li:nth-child(" + i
									+ ") > div > div:nth-child(" + j + ") > div.info-hall > ul > li:nth-child(2)");// 영화관명
							Elements seat = doc.select("body > div > div.sect-showtimes > ul > li:nth-child(" + i
									+ ") > div > div:nth-child(" + j + ") > div.info-hall > ul > li:nth-child(3)");// 관
																													// 좌석수
							System.out.println(screen.text());
							System.out.println(place2.text());
							System.out.println(seat.text());
							System.out.println("");
							hall_screen = screen.text();
							hall_place = place2.text();
							hall_seat = seat.text();

							Elements starttime = doc.select("body > div > div.sect-showtimes > ul > li:nth-child(" + i
									+ ") > div > div:nth-child(2) > div.info-timetable > ul > li > a > em");// 시작시간 밑에
																											// for문을
																											// 돌리기위한
																											// count를
																											// 세기위해 필요

							for (int k = 1; k <= starttime.size(); k++) {
								Elements starttime2 = doc.select("body > div > div.sect-showtimes > ul > li:nth-child("
										+ i + ") > div > div:nth-child(" + j
										+ ") > div.info-timetable > ul > li:nth-child(" + k + ")  > a > em");// 시작시간
								Elements seatleft = doc.select("body > div > div.sect-showtimes > ul > li:nth-child("
										+ i + ") > div > div:nth-child(" + j
										+ ") > div.info-timetable > ul > li:nth-child(" + k + ")  > a > span");// 잔여좌석

								System.out.println(starttime2.text());
								System.out.println(seatleft.text());
								seatleft_str = seatleft.text();//잔여좌석

								 
								Elements ticket = doc.select("body > div > div.sect-showtimes > ul > li:nth-child(" + i
										+ ") > div > div:nth-child(" + j + ") > div.info-timetable > ul > li:nth-child("
										+ k + ") > a");
								for (Element article : ticket) {
									String href = article.attr("abs:href"); // a태그 href의 절대주소를 얻어낸다.
									
									if (seatleft_str.substring(0, 3).equals("준비중")) {
										cs.insertdata(areacode, theatercode, date,
												movie_title, movie_genre, movie_runtime, movie_release , movie_age_num, movie_status,
												hall_screen, hall_place, hall_seat);
									} else {
										seatleft_str = seatleft_str.replace("잔여좌석", "");
										seatleft_str = seatleft_str.replace("석", "");
										seatleft_num = Integer.parseInt(seatleft_str);
										String movie_cd = href.substring(38, 46);
										String movie_cd_group = href.substring(62, 70);
										String play_ymd = href.substring(80, 88);
										String theater_cd = href.substring(100, 104);
										String play_start_tm = href.substring(119, 123);
										String area_cd = href.substring(132, 134);
										String screen_cd = href.substring(145);

										System.out.println(movie_cd);// movie_cd
										System.out.println(movie_cd_group);// movie_cd_group
										System.out.println(play_ymd);// play_ymd
										System.out.println(theater_cd);// theater_cd
										System.out.println(play_start_tm);// play_start_tm
										System.out.println(area_cd);// area_cd
										System.out.println(screen_cd);// screen_cd

										cs.insertdata(areacode, theatercode, date, movie_title, movie_genre,
												movie_runtime, movie_release, movie_age_num, movie_status, hall_screen,
												hall_place, hall_seat, movie_cd, movie_cd_group, play_ymd, theater_cd,
												play_start_tm, area_cd, screen_cd , seatleft_num);
									}
								}
								System.out.println("###########################");
							}
							System.out.println("*************************");
						}

						System.out.println("-----------------------------");
					}


					System.out.println(theatercode+" 관 데이터 입력 끝");
				}
				System.out.println(areacode+" 지역 데이터 입력 끝");
			}
			System.out.println(date+" 날짜 데이터 입력 끝");
		} // 맨 위 for문 끝
		System.out.println("전체 데이터 입력 끝");
	}

	/**
	 * URL 완성
	 * 
	 * @param areacode
	 * @param theatercode
	 * @param date
	 * @return
	 */

	public static String getParameter(String areacode, String theatercode, String date) {//url 파라미터 리턴
		String params = "areacode=" + areacode + "&theatercode=" + theatercode + "&date=" + date + "&screencodes="
				+ "&screenratingcode=" + "&regioncode=" + "";

		return params;
	}



}

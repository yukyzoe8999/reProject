package MovieCroll;


	import java.io.IOException;
	import java.util.ArrayList;

	import org.jsoup.Jsoup;
	import org.jsoup.nodes.Document;
	import org.jsoup.nodes.Element;
	import org.jsoup.select.Elements;

	public class movie_info2 {

		public static void main(String[] args) throws IOException {
			for (int i = 0; i < 3; i++) {
				String url = getURL(i);
				Document doc = Jsoup.connect(url).get();
				Elements image = doc.select(
						"#contents > div.wrap-movie-chart > div.sect-movie-chart > ol > li > div.box-image > a > span > img");

				/* 배열 */
				ArrayList<Integer> detail_cd = new ArrayList<Integer>();
				ArrayList<String> title_list = new ArrayList<String>();
				ArrayList<String> rate_list = new ArrayList<String>();
				ArrayList<String> freeegg_list = new ArrayList<String>();
				ArrayList<String> date_list = new ArrayList<String>();

				/* 가중치 */
				int cnt = 0;

				/* 이미지 가져오기 */
				for (Element e : image) {
					String src = e.getElementsByAttribute("src").attr("src");
//	               System.out.println(src);
					String src2 = src.substring(52, 57);
					if (src2.contains("/")) {
						src2 = src2.replace("/", "");
					}
					detail_cd.add(Integer.parseInt(src2));
					// System.out.println(detail_cd);

//	               URL imgUrl = new URL(src);
//	               BufferedImage jpg = ImageIO.read(imgUrl);
//	               File file = new File("C:\\image\\"+detail_cd+".jpg");
//	               ImageIO.write(jpg, "jpg", file); 

				} // foreach 끝

				/* 메인화면 정보 가져오기 */
				Elements title = doc.select(
						"#contents > div.wrap-movie-chart > div.sect-movie-chart > ol > li > div.box-contents > a > strong");
				for (Element t : title) {
					// System.out.println(t.text());
					title_list.add(t.text());
					Elements rate = doc.select(
							"#contents > div.wrap-movie-chart > div.sect-movie-chart > ol > li > div.box-contents > div > strong > span");
					rate_list.add(rate.text());
					Elements free_egg = doc.select(
							"#contents > div.wrap-movie-chart > div.sect-movie-chart > ol > li > div.box-contents > div > div > span.percent");
					freeegg_list.add(free_egg.get(cnt).text());
					Elements date = doc.select(
							"#contents > div.wrap-movie-chart > div.sect-movie-chart > ol > li > div.box-contents > span.txt-info > strong");
					date_list.add(date.get(cnt).text());

					cnt++;

				}

				// System.out.println(rate_list);
				// System.out.println("전체페이지:" +freeegg_list);
				// System.out.println(date_list);

				/* ArrayList 선언 */
				ArrayList<String> status_list = new ArrayList<String>();
				ArrayList<String> detail_title_list = new ArrayList<String>();
				ArrayList<String> name_list = new ArrayList<String>();

				ArrayList<String> director_list = new ArrayList<String>();
				ArrayList<String> actor_list = new ArrayList<String>();

				ArrayList<String> genre_list = new ArrayList<String>();
				ArrayList<String> age_runningtime_country_list = new ArrayList<String>();
				ArrayList<String> age_list = new ArrayList<String>();
				ArrayList<String> runningtime_list = new ArrayList<String>();
				ArrayList<String> country_list = new ArrayList<String>();
				ArrayList<String> detail_date_list = new ArrayList<String>();
				ArrayList<String> detail_rate_list = new ArrayList<String>();
				ArrayList<String> detail_freeegg_list = new ArrayList<String>();
				ArrayList<String> movie_info_list = new ArrayList<String>();
				ArrayList<String> pre_list = new ArrayList<String>();

				ArrayList<String> str = new ArrayList<String>();
				ArrayList<String> str_1 = new ArrayList<String>();
				ArrayList<String> cut_date = new ArrayList<String>();
				ArrayList<String> age_rc = new ArrayList<String>();

				
	/////////////////////////////////////////////////////////////////////////////////////

				/* 영화 상세페이지로 이동해서 정보 가져오기 */
				for (int num = 0; num < detail_cd.size(); num++) {
					url = getDetailURL(detail_cd, num);
					doc = Jsoup.connect(url).get();

					/* 개봉날짜와 연령, 러닝타임, 개봉국가를 나누기 위한 dt, dd 갯수 세기 */
					Elements dt = doc.select("#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dt");
					Elements dd = doc.select("#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd");
					for (Element a : dt) {
						str.add(a.text());

					}
					for (Element b : dd) {
						str_1.add(b.text());
					}
//				       System.out.println(str);
//				       System.out.println("dd: "+str.size());
//				       System.out.println(str_1);
//					 System.out.println("dt :"+str_1.size());
					int sum = str.size() + str_1.size();
					// System.out.println(sum);
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					Elements detail_title = doc.select("#select_main > div.sect-base-movie > h3 > strong");

					/* 한번에 가져올 수 있는 정보들 */
					for (Element d : detail_title) {
						detail_title_list.add(d.text());

						Elements status = doc
								.select("#select_main > div.sect-base-movie > div.box-contents > div.title > em > span");
						status_list.add(status.text());

						Elements rate = doc.select(
								"#select_main > div.sect-base-movie > div.box-contents > div.score > strong > span");
						detail_rate_list.add(rate.text());

						Elements freeegg = doc.select(
								"#select_main > div.sect-base-movie > div.box-contents > div.score > div > span.percent");
						detail_freeegg_list.add(freeegg.text());
						// System.out.println(freeegg.text());

						Elements movie_info = doc.select("#menu > div.col-detail > div.sect-story-movie");
						movie_info_list.add(movie_info.text());

					}

					/* if문써서 잘라서 가져올 수 있는 정보들 */
					if (sum == 9) {
						Elements detail_date = doc.select(
								"#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child("
										+ sum + ")");
						cut_date.add(detail_date.text());
						Elements detail_agerc = doc.select(
								"#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child("
										+ (sum - 2) + ")");
						age_rc.add(detail_agerc.text());
						Elements detail_director = doc.select(
								"#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child(2) > a");
						director_list.add(detail_director.text());
						Elements detail_actor = doc.select("#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child(5) > a");
						actor_list.add(detail_actor.text());
						Elements detail_genre = doc.select("#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dt:nth-child(6)");
						genre_list.add(detail_genre.text());

					} else if (sum == 10) {
						Elements detail_date = doc.select(
								"#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child("
										+ sum + ")");
						cut_date.add(detail_date.text());
						Elements detail_agerc = doc.select(
								"#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child("
										+ (sum - 2) + ")");
						age_rc.add(detail_agerc.text());
						Elements detail_director = doc.select(
								"#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child(2) > a");
						director_list.add(detail_director.text());
						Elements detail_actor = doc.select("#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child(5) > a");
						actor_list.add(detail_actor.text());
						Elements detail_genre = doc.select("#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dt:nth-child(6)");
						genre_list.add(detail_genre.text());
					} else if (sum == 11) {
						Elements detail_date = doc.select(
								"#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child("
										+ sum + ")");
						cut_date.add(detail_date.text());
						Elements detail_agerc = doc.select(
								"#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child("
										+ (sum - 2) + ")");
						age_rc.add(detail_agerc.text());
						Elements detail_director = doc.select(
								"#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child(2) > a");
						director_list.add(detail_director.text());
						Elements detail_actor = doc.select("#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child(5) > a");
						actor_list.add(detail_actor.text());
						Elements detail_genre = doc.select("#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dt:nth-child(6)");
						genre_list.add(detail_genre.text());
					} else if (sum == 12) {
						// System.out.println("dd: "+str.size());
//					    	   System.out.println("dt :"+str_1.size());
//					    	   System.out.println("__________________");
						if (str.size() == 6 && str_1.size() == 6) {
							Elements detail_date = doc.select(
									"#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child("
											+ sum + ")");
							cut_date.add(detail_date.text());
							Elements detail_agerc = doc.select(
									"#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child("
											+ (sum - 2) + ")");
							age_rc.add(detail_agerc.text());
							Elements detail_director = doc.select(
									"#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child(2) > a");
							director_list.add(detail_director.text());
							Elements detail_actor = doc.select("#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child(5) > a");
							actor_list.add(detail_actor.text());
							Elements detail_genre = doc.select("#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dt:nth-child(6)");
							genre_list.add(detail_genre.text());
						} else {
							Elements detail_date = doc.select(
									"#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child("
											+ 10 + ")");
							cut_date.add(detail_date.text());
							Elements detail_agerc = doc.select(
									"#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child("
											+ 8 + ")");
							age_rc.add(detail_agerc.text());
						}
					} else if (sum == 13) {
						Elements detail_date = doc.select(
								"#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child("
										+ sum + ")");
						cut_date.add(detail_date.text());
						Elements detail_agerc = doc.select(
								"#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child("
										+ (sum - 2) + ")");
						age_rc.add(detail_agerc.text());
						Elements detail_director = doc.select(
								"#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child(2) > a");
						director_list.add(detail_director.text());
						Elements detail_actor = doc.select("#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child(5) > a");
						actor_list.add(detail_actor.text());
						Elements detail_genre = doc.select("#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dt:nth-child(6)");
						genre_list.add(detail_genre.text());
					} else if (sum == 14) {

						Elements detail_date = doc.select(
								"#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child(" + 12
										+ ")");
						cut_date.add(detail_date.text());
						Elements detail_agerc = doc.select(
								"#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child(" + 10
										+ ")");
						age_rc.add(detail_agerc.text());
						Elements detail_director = doc.select(
								"#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child(2) > a");
						director_list.add(detail_director.text());
						Elements detail_actor = doc.select("#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child(5) > a");
						actor_list.add(detail_actor.text());
						Elements detail_genre = doc.select("#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dt:nth-child(6)");
						genre_list.add(detail_genre.text());
					} else if (sum == 15) {
						Elements detail_date = doc.select(
								"#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child("
										+ sum + ")");
						cut_date.add(detail_date.text());
						Elements detail_agerc = doc.select(
								"#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child("
										+ (sum - 2) + ")");
						age_rc.add(detail_agerc.text());
						Elements detail_director = doc.select(
								"#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child(2) > a");
						director_list.add(detail_director.text());
						Elements detail_actor = doc.select("#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child(5) > a");
						actor_list.add(detail_actor.text());
						Elements detail_genre = doc.select("#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dt:nth-child(6)");
						genre_list.add(detail_genre.text());
					}

					/* 연령 러닝타임 개봉국 */
					Elements age_runningtime_country = doc.select(
							"#select_main > div.sect-base-movie > div.box-contents > div.spec > dl > dd:nth-child(9)");

					for (Element arc : age_runningtime_country) {
						String arc_ = arc.text();
						// System.out.println(arc_);
						age_runningtime_country_list.add(arc_);

					}
					// System.out.println("ddddddd"+age_rc);

//				    	   for(int s=0; s<age_rc.size(); s++) {
//				    		   String ss = age_rc.get(s);
//				    		   System.out.println(ss);
//				    		   
//						       String str1= "";
//						       String str2= "";
//						       String str3= "";
//						       
//						       if((ss.length()-1)==ss.lastIndexOf(",")) {
//						    	   int k = ss.indexOf(",");
//							       str1 = ss.substring(0,k);
//							       str2 = ss.substring(k+2);
//							       k = str2.indexOf(",");
//							       str3 = str2.substring(k+1); 
//							       str2 = str2.substring(0,k);
//							       System.out.println(str1);
//							       System.out.println(str2);
//							       System.out.println(str3);
//						        }  else {
//						           int k = ss.indexOf(",");
//						           str1 = ss.substring(0,k);
//						           str2 = ss.substring(k+2);
//						           k = str2.indexOf(",");
//						           str3 = str2.substring(k+2); 
//						           str2 = str2.substring(0,k);
//						           System.out.println(str1);
//						           System.out.println(str2);
//						           System.out.println(str3);
//						        }
//				    	   }

				}
//				System.out.println(status_list);
//				System.out.println(detail_title_list);
//				System.out.println(name_list);
//				System.out.println(genre_list);
//				System.out.println(age_list);  
//				System.out.println(date_list);
//				System.out.println(detail_date_list);
//				System.out.println(detail_freeegg_list);
//				System.out.println(movie_info_list);
//				System.out.println(pre_list);
//				System.out.println(director_list);
//				System.out.println(actor_list);
//				System.out.println(genre_list);

			}

		}

		public static String getURL(int i) {
			String URL[] = { "http://www.cgv.co.kr/movies/", "http://www.cgv.co.kr/movies/pre-movies.aspx",
					"http://www.cgv.co.kr/movies/?lt=3" };

			return URL[i];
		}

		public static String getDetailURL(ArrayList<Integer> detail_cd, int num) {
			String url = "http://www.cgv.co.kr/movies/detail-view/?midx=";
			String midx_num = detail_cd.get(num).toString();
			url = url + midx_num;

			return url;

		}

	}

package com.cinema.crawling;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.sanselan.ImageReadException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import MovieCroll.MovieService;

public class MovieCrawlingCtr2222 {    
   
	public static void main(String[] args) throws IOException, ImageReadException {
		MovieService ms = new MovieService();
		WebDriver driver = null;
		int number=0;

		for (int i = 0; i < 3; i++) {
			List<MovieCrawlingVo> MovieCrawlingdata = new ArrayList<MovieCrawlingVo>();
			/* 가중치 */
			int cnt = 0;
			if(i==0) {
				try {
					System.setProperty("webdriver.chrome.driver", "c:\\selenium\\chromedriver.exe");
					driver = new ChromeDriver();
					JavascriptExecutor js = (JavascriptExecutor) driver;
					driver.get("http://www.cgv.co.kr/movies/");
					driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
					WebElement element = driver.findElement(By.xpath("//*[@id=\"contents\"]/div[1]/div[3]/button"));
					element.click();
					List<WebElement> Mtitle = driver
							.findElements(By.cssSelector("#movie_more_container > li > div.box-contents > a > strong"));
					List<WebElement> Mrate = driver.findElements(
							By.cssSelector("#movie_more_container > li > div.box-contents > div > strong > span"));
					List<WebElement> Mfree_egg = driver.findElements(
							By.cssSelector("#movie_more_container > li > div.box-contents > div > div > span.percent"));
					List<WebElement> Mdate = driver.findElements(
							By.cssSelector("#movie_more_container > li > div.box-contents > span.txt-info > strong"));
					List<WebElement> Mimgnum = driver
							.findElements(By.cssSelector("#movie_more_container > li > div.box-image > a > span > img"));


					for (int a = 0; a<Mtitle.size(); a++) {
						MovieCrawlingVo mvc = new MovieCrawlingVo();
						
						mvc.setTitle_list(Mtitle.get(a).getText());
						System.out.println("111111111111111111111111111111111111111"+Mtitle.get(a).getText());
						
						String[] b = ((WebElement) Mrate).getText().split("%");
						mvc.setRate_list(Double.parseDouble(b[a]));
						
						mvc.setFreeegg_list(Mfree_egg.get(a).getText());
					//	System.out.println(Mfree_egg.get(a).getText());
						mvc.setDate_list(Mdate.get(a).getText());
					//	System.out.println(Mdate.get(a).getText());
					//	String more_title = Mimgnum.getAttribute("src");
					//	String src3 = more_title.substring(52, 57);
					//	System.out.println("src3 : "+src3);
//						if (src3.contains("/")) {
//							src3 = src3.replace("/", "");	
//						}				
//						mvc.setDetail_cd(Integer.parseInt(src3));
//						mvc.setMovie_imgPath(more_title);
//						
//						MovieCrawlingdata.add(mvc);
//					}
					/*
					 * for (WebElement m : Mrate) { //System.out.println("예매율 : " + ele.getText());
					 * String[] a = m.getText().split("%"); System.out.println("split : "+a[i]);
					 * for(int j =0; j<a.length; j++) { rate_list.add(Double.parseDouble(a[j])); } }
					 * for (WebElement f : Mfree_egg) { //System.out.println("프리에그 : " +
					 * ele.getText()); freeegg_list.add(f.getText()); } for (WebElement d : Mdate) {
					 * //System.out.println("개봉날짜 : " + ele.getText()); date_list.add(d.getText());
					 * } for (WebElement ele : Mimgnum) { //System.out.println("SRC : " +
					 * ele.getText());
					 * 
					 * String more_title = ele.getAttribute("src"); String src3 =
					 * more_title.substring(52, 57); System.out.println("src3 : "+src3); if
					 * (src3.contains("/")) { src3 = src3.replace("/", ""); }
					 * detail_cd.add(Integer.parseInt(src3)); Movie_imgPath.add(more_title); }
					 */
					}
				} catch (Throwable e) {
					e.printStackTrace();
				} finally {
					driver.close();
				}
			}
			
			String url = getURL(i);
			Document doc = Jsoup.connect(url).get();
			Elements image = doc.select(
					"#contents > div.wrap-movie-chart > div.sect-movie-chart > ol > li > div.box-image > a > span > img");		
			/* 메인화면 이미지 가져오기 */
			for (Element e : image) {
				String src = e.getElementsByAttribute("src").attr("src");
			//	Movie_imgPath.add(src);
				//System.out.println(Movie_imgPath);
				String src2 = src.substring(52, 57);
				//System.out.println("src2 : "+src2);
				if (src2.contains("/")) {
					src2 = src2.replace("/", "");				
				}				
			//	detail_cd.add(Integer.parseInt(src2));
							
			} // foreach 끝
			
			
			
			/* 메인화면 정보 가져오기 */
			Elements title = doc.select(
					"#contents > div.wrap-movie-chart > div.sect-movie-chart > ol > li > div.box-contents > a > strong");
			
			for(int m=0; m<title.size();m++) {
				Elements free_egg = doc.select(
						"#contents > div.wrap-movie-chart > div.sect-movie-chart > ol > li > div.box-contents > div > div > span.percent");
				
			}
			for (Element t : title) {
				// System.out.println(t.text());
			//	title_list.add(t.text());
				Elements rate = doc.select(
						"#contents > div.wrap-movie-chart > div.sect-movie-chart > ol > li > div.box-contents > div > strong > span");
				
				String[] a = rate.get(cnt).text().split("%");
				
				
				for(int j =0; j<a.length; j++) {
					double s =  Double.parseDouble(a[j]);
					System.out.println(s);
				//	rate_list.add(s);
				}
				
				
			//	freeegg_list.add(free_egg.get(cnt).text());
				Elements date = doc.select(
						"#contents > div.wrap-movie-chart > div.sect-movie-chart > ol > li > div.box-contents > span.txt-info > strong");
				//date_list.add(date.get(cnt).text());

				cnt++;

			}

			// System.out.println(rate_list);
			// System.out.println("전체페이지:" +freeegg_list);
			//System.out.println(date_list);

/////////////////////////////////////////////////////////////////////////////////////

			/* 영화 상세페이지로 이동해서 정보 가져오기 */
			for (int num = 0; num < detail_cd.size(); num++) {
				System.out.println("코드 사이즈 : "+detail_cd.size());
				
				url = getDetailURL(detail_cd, num);
				doc = Jsoup.connect(url).get();
				System.out.println("url : "+url);


				Elements detail_title = doc.select("#select_main > div.sect-base-movie > div.box-contents > div.title > strong");
				
				
				/* 한번에 가져올 수 있는 정보들 */
				for (Element d : detail_title) {
				//	detail_title_list.add(d.text());
					
					Elements status = doc
							.select("#select_main > div.sect-base-movie > div.box-contents > div.title > em > span");
					//status_list.add(status.text());
					
					Elements rate = doc.select(
							"#select_main > div.sect-base-movie > div.box-contents > div.score > strong > span");
					//detail_rate_list.add(rate.text());

					Elements freeegg = doc.select(
							"#select_main > div.sect-base-movie > div.box-contents > div.score > div > span.percent");
					//detail_freeegg_list.add(freeegg.text());

					Elements movie_info = doc.select("#menu > div.col-detail > div.sect-story-movie");
				//	movie_info_list.add(movie_info.text());

					Elements movie_spec = doc
							.select("#select_main > div.sect-base-movie > div.box-contents > div.spec");
//					movie_spec_list.add(movie_spec.text());

				}
			}
			
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////
			

//	System.out.println(detail_rate_list);		
//			System.out.println(status_list);
//			System.out.println(detail_title_list);
//			System.out.println(name_list);
//			System.out.println(genre_list);
//			System.out.println(age_list);  
//			System.out.println(date_list);
//			System.out.println(detail_date_list);
			// System.out.println("프리에그 : "+detail_freeegg_list);
//			System.out.println(movie_info_list);
//			System.out.println(pre_list);
//			System.out.println(director_list);
//			System.out.println(actor_list);
//			System.out.println(genre_list);
			// System.out.println(movie_spec_list);
		//	System.out.println("title_list : "+title_list);
			if(i==0) {
				number = 0;
			} else if(i==1) {
				number=1;
			} else if(i==2) {
				number=2;
			}
			MovieCrawlingVo mdl = new MovieCrawlingVo(detail_cd,title_list,rate_list,freeegg_list,date_list,Movie_imgPath, number);	
			MovieCrawlingVo mdl_detail = new MovieCrawlingVo(detail_cd,status_list,detail_title_list,detail_rate_list,detail_freeegg_list,movie_spec_list, movie_info_list, number);
		    mc.insertMainList(mdl);
			ms.Movie_Detail_Insert(mdl_detail);
		    
		  
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

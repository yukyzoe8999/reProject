package MovieCroll;

import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.sanselan.ImageReadException;
import org.apache.sanselan.Sanselan;
import org.apache.sanselan.common.byteSources.ByteSource;
import org.apache.sanselan.common.byteSources.ByteSourceFile;
import org.apache.sanselan.formats.jpeg.JpegImageParser;
import org.apache.sanselan.formats.jpeg.segments.UnknownSegment;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import data.Movie_Detail_List;

public class Movie_information {
	
	public static void main(String[] args) throws IOException, ImageReadException {
		MovieService ms = new MovieService();
		WebDriver driver = null;
		int number=0;

		for (int i = 0; i < 3; i++) {
	
			/* 메인화면 배열 */
			ArrayList<Integer> detail_cd = new ArrayList<Integer>();
			ArrayList<String> title_list = new ArrayList<String>();
			ArrayList<Double> rate_list = new ArrayList<Double>();
			ArrayList<String> freeegg_list = new ArrayList<String>();
			ArrayList<String> date_list = new ArrayList<String>();
			ArrayList<String> Movie_imgPath = new ArrayList<String>();

			/* 상세페이지 ArrayList 선언 */
			ArrayList<String> status_list = new ArrayList<String>(); // 현재상영상태
			ArrayList<String> detail_title_list = new ArrayList<String>(); // 영화제목
			ArrayList<String> movie_spec_list = new ArrayList<String>();

			ArrayList<String> detail_rate_list = new ArrayList<String>(); // 예매율
			ArrayList<String> detail_freeegg_list = new ArrayList<String>(); // 영화기대지수
			ArrayList<String> movie_info_list = new ArrayList<String>(); // 영화정보
			
			String url = getURL(i);
			Document doc = Jsoup.connect(url).get();
			Elements image = doc.select(
					"#contents > div.wrap-movie-chart > div.sect-movie-chart > ol > li > div.box-image > a > span > img");
			for (Element e : image) {
				String src = e.getElementsByAttribute("src").attr("src");
				//System.out.println(src);	
				//System.out.println("여기는 처음 이미지 src 받아오는 곳");
				}			
			/* 가중치 */
			int cnt = 0;
			int imgnum=0;
			int count = 0;
			BufferedImage jpg;
			
//			ArrayList<Integer> detail_cd_two = new ArrayList<Integer>();
			

			
			if(i==0) {
				System.out.println("세레늄으로 들어가는 곳");
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

//		         ArrayList<Integer> detail_cd = new ArrayList<Integer>();

					for (WebElement t : Mtitle) {
						//System.out.println("title : " + t.getText());
						title_list.add(t.getText());
					}
					for (WebElement m : Mrate) {
						//System.out.println("예매율 : " + ele.getText());	
						String[] a = m.getText().split("%");
						//System.out.println("split : "+a[i]);
						for(int j =0; j<a.length; j++) {
						rate_list.add(Double.parseDouble(a[j]));
						}
					}
					for (WebElement f : Mfree_egg) {
						//System.out.println("프리에그 : " + ele.getText());
						freeegg_list.add(f.getText());
					}
					for (WebElement d : Mdate) {
						//System.out.println("개봉날짜 : " + ele.getText());
						date_list.add(d.getText());
					}
					for (WebElement ele : Mimgnum) {
						//System.out.println("SRC : " + ele.getText());

						String more_title = ele.getAttribute("src");
						String src3 = more_title.substring(52, 57);
						//System.out.println("src3 : "+src3);
						if (src3.contains("/")) {
							src3 = src3.replace("/", "");	
						}				
						detail_cd.add(Integer.parseInt(src3));
						Movie_imgPath.add(more_title);
					}

				} catch (Throwable e) {
					e.printStackTrace();
				} finally {
					driver.close();
				}
			}
			
			/* 메인화면 이미지 가져오기 */
			for (Element e : image) {
				System.out.println("메인화면 이미지 가져오는 곳");
				String src = e.getElementsByAttribute("src").attr("src");
				Movie_imgPath.add(src);
				//System.out.println(Movie_imgPath);
				String src2 = src.substring(52, 57);
				//System.out.println("src2 : "+src2);
				if (src2.contains("/")) {
					src2 = src2.replace("/", "");				
				}				
				detail_cd.add(Integer.parseInt(src2));
				
//				for(int j=0; j<detail_cd.size();j++) {
//					if(!(detail_cd_two.contains(detail_cd.get(i)))) {
//						detail_cd_two.addAll(detail_cd);
//					}
//				}
				//System.out.println("첫번째 : "+detail_cd);
				//System.out.println("두번째 : "+detail_cd_two);

//				try {
//					URL imgUrl = new URL(src);
//					jpg = ImageIO.read(imgUrl);
//					File file = new File("C:\\image\\" + detail_cd.get(imgnum) + ".jpg");
//					ImageIO.write(jpg, "jpg", file);
//					imgnum++;
//				} catch(Exception e1) {
////					e1.printStackTrace();
//					detail_cd.remove(imgnum);
//					System.out.println("-------예외처리 됨------");
//				}
					
		
				
			} // foreach 끝
			
			/* 메인화면 정보 가져오기 */
			Elements title = doc.select(
					"#contents > div.wrap-movie-chart > div.sect-movie-chart > ol > li > div.box-contents > a > strong");
			for (Element t : title) {
				System.out.println("메인화면 정보 가져오는 곳");
				// System.out.println(t.text());
				title_list.add(t.text());
				Elements rate = doc.select(
						"#contents > div.wrap-movie-chart > div.sect-movie-chart > ol > li > div.box-contents > div > strong > span");
				
				String[] a = rate.get(cnt).text().split("%");
				
				
				for(int j =0; j<a.length; j++) {
					double s =  Double.parseDouble(a[j]);
					//System.out.println(s);
					rate_list.add(s);
				}
				
				
//				rate_list.add(rate.get(cnt).text());
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
			//System.out.println(date_list);

/////////////////////////////////////////////////////////////////////////////////////

			/* 영화 상세페이지로 이동해서 정보 가져오기 */
			for (int num = 0; num < detail_cd.size(); num++) {
				System.out.println("상세페이지 정보 가져오기");
			//	System.out.println("코드 사이즈 : "+detail_cd.size());
				
				url = getDetailURL(detail_cd, num);
				doc = Jsoup.connect(url).get();
				//System.out.println("url : "+url);


				Elements detail_title = doc.select("#select_main > div.sect-base-movie > div.box-contents > div.title > strong");
				
				

				/* 한번에 가져올 수 있는 정보들 */
				for (Element d : detail_title) {
					detail_title_list.add(d.text());

//					Elements MORE_title = doc.select("#select_main > div.sect-base-movie > div.box-contents > div.title > strong");
//					detail_title_list.add(MORE_title.text());
					
					Elements status = doc
							.select("#select_main > div.sect-base-movie > div.box-contents > div.title > em > span");
					status_list.add(status.text());
//					Elements MORE_status = doc
//							.select("#select_main > div.sect-base-movie > div.box-contents > div.title > em > span");
//					status_list.add(MORE_status.text());
					
					Elements rate = doc.select(
							"#select_main > div.sect-base-movie > div.box-contents > div.score > strong > span");
					detail_rate_list.add(rate.text());
//					Elements MORE_rate = doc.select(
//							"#select_main > div.sect-base-movie > div.box-contents > div.score > strong > span");
//					detail_rate_list.add(MORE_rate.text());

					Elements freeegg = doc.select(
							"#select_main > div.sect-base-movie > div.box-contents > div.score > div > span.percent");
					detail_freeegg_list.add(freeegg.text());
//					Elements MORE_freeegg = doc.select(
//							"#select_main > div.sect-base-movie > div.box-contents > div.score > div > span.percent");
//					detail_freeegg_list.add(MORE_freeegg.text());

					Elements movie_info = doc.select("#menu > div.col-detail > div.sect-story-movie");
					movie_info_list.add(movie_info.text());
//					Elements MORE_movie_info = doc.select("#menu > div.col-detail > div.sect-story-movie");
//					movie_info_list.add(MORE_movie_info.text());

					Elements movie_spec = doc
							.select("#select_main > div.sect-base-movie > div.box-contents > div.spec");
					movie_spec_list.add(movie_spec.text());
//					Elements MORE_movie_spec = doc
//							.select("#select_main > div.sect-base-movie > div.box-contents > div.spec");
//					movie_spec_list.add(MORE_movie_spec.text());

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
			//System.out.println("title_list : "+title_list);
			if(i==0) {
				number = 0;
			} else if(i==1) {
				number=1;
			} else if(i==2) {
				number=2;
			}
			//Movie_Detail_List mdl = new Movie_Detail_List(detail_cd,title_list,rate_list,freeegg_list,date_list,Movie_imgPath, number);	
			//Movie_Detail_List mdl_detail = new Movie_Detail_List(detail_cd,status_list,detail_title_list,detail_rate_list,detail_freeegg_list,movie_spec_list, movie_info_list, number);
		    //ms.Movie_Main_Insert(mdl);
			//ms.Movie_Detail_Insert(mdl_detail);
		    
		  
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
	////////////////////////////////////////////////////////////////////////////////////////////////////////



}
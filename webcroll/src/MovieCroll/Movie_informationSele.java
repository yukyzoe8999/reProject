package MovieCroll;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Movie_informationSele {
	public static void main(String... args) {
		WebDriver driver = null;
		try {
			System.setProperty("webdriver.chrome.driver", "c:\\selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			driver.get("http://www.cgv.co.kr/movies/");
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			WebElement element = driver.findElement(By.xpath("//*[@id=\"contents\"]/div[1]/div[3]/button"));
			element.click();
			List<WebElement> title = driver
					.findElements(By.cssSelector("#movie_more_container > li > div.box-contents > a > strong"));
			List<WebElement> rate = driver.findElements(
					By.cssSelector("#movie_more_container > li > div.box-contents > div > strong > span"));
			List<WebElement> free_egg = driver.findElements(
					By.cssSelector("#movie_more_container > li > div.box-contents > div > div > span.percent"));
			List<WebElement> date = driver.findElements(
					By.cssSelector("#movie_more_container > li > div.box-contents > span.txt-info > strong"));
			List<WebElement> imgnum = driver
					.findElements(By.cssSelector("#movie_more_container > li > div.box-image > a > span > img"));

//         ArrayList<Integer> detail_cd = new ArrayList<Integer>();

			for (WebElement t : title) {

				System.out.println("title : " + t.getText());
			}
			for (WebElement ele : rate) {

				System.out.println("예매율 : " + ele.getText());
			}
			for (WebElement ele : free_egg) {

				System.out.println("프리에그 : " + ele.getText());
			}
			for (WebElement ele : date) {

				System.out.println("개봉날짜 : " + ele.getText());
			}
			for (WebElement ele : imgnum) {

				System.out.println("SRC : " + ele.getText());

				String a = ele.getAttribute("src");
				System.out.println("11111111111111111111111111111::" + a);
			}

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}
	}
}
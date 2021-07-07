package MovieCroll;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ImageMain {

   public static void main(String[] args) throws IOException{
      Document doc = Jsoup.connect("http://www.cgv.co.kr/movies/").get();
        String folder = doc.title();
//        Elements element = doc.select("#contents > div.wrap-movie-chart > div.sect-movie-chart > ol > li > div.box-image > a > span > img");
        Elements element = doc.select("#movie_more_container > li:nth-child(1) > div.box-image > a > span > img");
        System.out.println("dddddddddddddd"+element);
        Elements img = element.select("img");

        String filename = "사진더보기";
        int i=0;
        for (Element e : img) {
            String url = e.getElementsByAttribute("src").attr("src");
            System.out.println(url);
            URL imgUrl = new URL(url);
            BufferedImage jpg = ImageIO.read(imgUrl);
            File file = new File("C:\\image\\"+filename+(++i)+".jpg");
            ImageIO.write(jpg, "jpg", file);
        }
        System.out.println("-----------");



   }

}
package data;

import java.util.ArrayList;

public class Movie_Detail_List {
	ArrayList<Integer> detail_cd;
	ArrayList<String> title_list;
	ArrayList<Double> rate_list;
	ArrayList<String> freeegg_list;
	ArrayList<String> date_list;
	ArrayList<String> Movie_imgPath;
	int number;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	/* 상세페이지 ArrayList 선언 */
	ArrayList<String> status_list;
	ArrayList<String> detail_title_list;
	ArrayList<String> movie_spec_list;

	ArrayList<String> detail_rate_list;
	ArrayList<String> detail_freeegg_list;
	ArrayList<String> movie_info_list;
	
	public Movie_Detail_List() {
		
	}
	public Movie_Detail_List(ArrayList<Integer> detail_cd, ArrayList<String> title_list, ArrayList<Double> rate_list,
			ArrayList<String> freeegg_list, ArrayList<String> date_list, ArrayList<String> Movie_imgPath, int number) {
		this.detail_cd = detail_cd;
		this.title_list = title_list;
		this.rate_list = rate_list;
		this.freeegg_list = freeegg_list;
		this.date_list = date_list;
		this.Movie_imgPath = Movie_imgPath;
		this.number = number;
	}

	public Movie_Detail_List(ArrayList<Integer> detail_cd,ArrayList<String> status_list, ArrayList<String> detail_title_list,
			ArrayList<String> detail_rate_list, ArrayList<String> detail_freeegg_list,ArrayList<String> movie_spec_list, ArrayList<String> movie_info_list) {
		this.detail_cd = detail_cd;
		this.status_list = status_list;
		this.detail_title_list = detail_title_list;
		this.movie_spec_list = movie_spec_list;
		this.detail_rate_list = detail_rate_list;
		this.detail_freeegg_list = detail_freeegg_list;
		this.movie_info_list = movie_info_list;
	}
	public ArrayList<Integer> getDetail_cd() {
		return detail_cd;
	}
	public void setDetail_cd(ArrayList<Integer> detail_cd) {
		this.detail_cd = detail_cd;
	}
	public ArrayList<String> getTitle_list() {
		return title_list;
	}
	public void setTitle_list(ArrayList<String> title_list) {
		this.title_list = title_list;
	}
	public ArrayList<Double> getRate_list() {
		return rate_list;
	}
	public void setRate_list(ArrayList<Double> rate_list) {
		this.rate_list = rate_list;
	}
	public ArrayList<String> getFreeegg_list() {
		return freeegg_list;
	}
	public void setFreeegg_list(ArrayList<String> freeegg_list) {
		this.freeegg_list = freeegg_list;
	}
	public ArrayList<String> getDate_list() {
		return date_list;
	}
	public void setDate_list(ArrayList<String> date_list) {
		this.date_list = date_list;
	}
	public ArrayList<String> getStatus_list() {
		return status_list;
	}
	public void setStatus_list(ArrayList<String> status_list) {
		this.status_list = status_list;
	}
	public ArrayList<String> getDetail_title_list() {
		return detail_title_list;
	}
	public void setDetail_title_list(ArrayList<String> detail_title_list) {
		this.detail_title_list = detail_title_list;
	}
	public ArrayList<String> getMovie_spec_list() {
		return movie_spec_list;
	}
	public void setMovie_spec_list(ArrayList<String> movie_spec_list) {
		this.movie_spec_list = movie_spec_list;
	}
	public ArrayList<String> getDetail_rate_list() {
		return detail_rate_list;
	}
	public void setDetail_rate_list(ArrayList<String> detail_rate_list) {
		this.detail_rate_list = detail_rate_list;
	}
	public ArrayList<String> getDetail_freeegg_list() {
		return detail_freeegg_list;
	}
	public void setDetail_freeegg_list(ArrayList<String> detail_freeegg_list) {
		this.detail_freeegg_list = detail_freeegg_list;
	}
	public ArrayList<String> getMovie_info_list() {
		return movie_info_list;
	}
	public void setMovie_info_list(ArrayList<String> movie_info_list) {
		this.movie_info_list = movie_info_list;
	}
	public ArrayList<String> getMovie_imgPath() {
		return Movie_imgPath;
	}
	public void setMovie_imgPath(ArrayList<String> movie_imgPath) {
		Movie_imgPath = movie_imgPath;
	}

}

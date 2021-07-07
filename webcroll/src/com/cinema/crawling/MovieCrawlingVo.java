package com.cinema.crawling;

import java.util.ArrayList;



public class MovieCrawlingVo {
	
	Integer detail_cd;
	String title_list;
	Double rate_list;
	String freeegg_list;
	String date_list;
	String Movie_imgPath;
	int number;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	/* 상세페이지 ArrayList 선언 */
	String status_list;
	String detail_title_list;
	String movie_spec_list;

	String detail_rate_list;
	String detail_freeegg_list;
	String movie_info_list;
	
	public MovieCrawlingVo() {
		
	}
	
	public MovieCrawlingVo(Integer detail_cd, String title_list, Double rate_list, String freeegg_list,
			String date_list, String movie_imgPath, int number) {
		super();
		this.detail_cd = detail_cd;
		this.title_list = title_list;
		this.rate_list = rate_list;
		this.freeegg_list = freeegg_list;
		this.date_list = date_list;
		Movie_imgPath = movie_imgPath;
		this.number = number;
	}
	
	
	public MovieCrawlingVo(int number, String status_list, String detail_title_list, String movie_spec_list,
			String detail_rate_list, String detail_freeegg_list, String movie_info_list) {
		super();
		this.number = number;
		this.status_list = status_list;
		this.detail_title_list = detail_title_list;
		this.movie_spec_list = movie_spec_list;
		this.detail_rate_list = detail_rate_list;
		this.detail_freeegg_list = detail_freeegg_list;
		this.movie_info_list = movie_info_list;
	}
	public Integer getDetail_cd() {
		return detail_cd;
	}
	public void setDetail_cd(Integer detail_cd) {
		this.detail_cd = detail_cd;
	}
	public String getTitle_list() {
		return title_list;
	}
	public void setTitle_list(String title_list) {
		this.title_list = title_list;
	}
	public Double getRate_list() {
		return rate_list;
	}
	public void setRate_list(Double rate_list) {
		this.rate_list = rate_list;
	}
	public String getFreeegg_list() {
		return freeegg_list;
	}
	public void setFreeegg_list(String freeegg_list) {
		this.freeegg_list = freeegg_list;
	}
	public String getDate_list() {
		return date_list;
	}
	public void setDate_list(String date_list) {
		this.date_list = date_list;
	}
	public String getMovie_imgPath() {
		return Movie_imgPath;
	}
	public void setMovie_imgPath(String movie_imgPath) {
		Movie_imgPath = movie_imgPath;
	}
	public String getStatus_list() {
		return status_list;
	}
	public void setStatus_list(String status_list) {
		this.status_list = status_list;
	}
	public String getDetail_title_list() {
		return detail_title_list;
	}
	public void setDetail_title_list(String detail_title_list) {
		this.detail_title_list = detail_title_list;
	}
	public String getMovie_spec_list() {
		return movie_spec_list;
	}
	public void setMovie_spec_list(String movie_spec_list) {
		this.movie_spec_list = movie_spec_list;
	}
	public String getDetail_rate_list() {
		return detail_rate_list;
	}
	public void setDetail_rate_list(String detail_rate_list) {
		this.detail_rate_list = detail_rate_list;
	}
	public String getDetail_freeegg_list() {
		return detail_freeegg_list;
	}
	public void setDetail_freeegg_list(String detail_freeegg_list) {
		this.detail_freeegg_list = detail_freeegg_list;
	}
	public String getMovie_info_list() {
		return movie_info_list;
	}
	public void setMovie_info_list(String movie_info_list) {
		this.movie_info_list = movie_info_list;
	}

	
	
}

package data;

import java.util.ArrayList;

public class Title {
	ArrayList<String> movie_title;
	ArrayList<String> movie_age;
	ArrayList<String> movie_genre;
	ArrayList<String> movie_release;
	ArrayList<String> movie_runtime;
	ArrayList<String> movie_screening;
	String date;
		
	public Title(ArrayList<String> movie_title, ArrayList<String> movie_age, ArrayList<String> movie_genre,
			ArrayList<String> movie_release, ArrayList<String> movie_runtime, ArrayList<String> movie_screening,
			String date) {
		this.movie_title = movie_title;
		this.movie_age = movie_age;
		this.movie_genre = movie_genre;
		this.movie_release = movie_release;
		this.movie_runtime = movie_runtime;
		this.movie_screening = movie_screening;
		this.date = date;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public ArrayList<String> getMovie_title() {
		return movie_title;
	}
	public void setMovie_title(ArrayList<String> movie_title) {
		this.movie_title = movie_title;
	}
	public ArrayList<String> getMovie_age() {
		return movie_age;
	}
	public void setMovie_age(ArrayList<String> movie_age) {
		this.movie_age = movie_age;
	}
	public ArrayList<String> getMovie_genre() {
		return movie_genre;
	}
	public void setMovie_genre(ArrayList<String> movie_genre) {
		this.movie_genre = movie_genre;
	}
	public ArrayList<String> getMovie_release() {
		return movie_release;
	}
	public void setMovie_release(ArrayList<String> movie_release) {
		this.movie_release = movie_release;
	}
	public ArrayList<String> getMovie_runtime() {
		return movie_runtime;
	}
	public void setMovie_runtime(ArrayList<String> movie_runtime) {
		this.movie_runtime = movie_runtime;
	}
	public ArrayList<String> getMovie_screening() {
		return movie_screening;
	}
	public void setMovie_screening(ArrayList<String> movie_screening) {
		this.movie_screening = movie_screening;
	}
}

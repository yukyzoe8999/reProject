package pp.main;

public class indexVO {
	int countryid;
	String country;
	String pic;
	
	public indexVO(int id, String country, String pic) {
		this.countryid = id;
		this.country = country;
		this.pic = pic;
	}
	

	public int getCountryid() {
		return countryid;
	}


	public void setCountryid(int countryid) {
		this.countryid = countryid;
	}


	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}

}

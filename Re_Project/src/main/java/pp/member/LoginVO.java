package pp.member;

public class LoginVO {
    private String id;
    private String password;
    private String remember;
    
    

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemember() {
        return remember;
    }
    
    public void setRemember(String remember) {
        this.remember = remember;
    }

}

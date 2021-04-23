package pp.member;

import org.springframework.web.multipart.MultipartFile;

public class UserVO {
	private String USERNO;
	private String id;
    private String password;
    private String name;
    private String email;


    /* 
     * 사진 
     */
    private MultipartFile photofile;


    
	public String getUSERNO() {
		return USERNO;
	}


	public void setUSERNO(String uSERNO) {
		USERNO = uSERNO;
	}


	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPass() {
		return password;
	}


	public void setPass(String pass) {
		this.password = pass;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public MultipartFile getPhotofile() {
		return photofile;
	}


	public void setPhotofile(MultipartFile photofile) {
		this.photofile = photofile;
	}
    
    

}

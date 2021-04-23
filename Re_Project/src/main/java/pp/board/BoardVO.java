package pp.board;

import java.util.Date;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public class BoardVO {

	int bid;
	String title;
	String writer_id;
	String content;
	Date regdate;
	int hit;
	String files;
	boolean pub;

	private List<MultipartFile> uploadfile;
	// 생성자
	public BoardVO() {

	}

	// 생성자 오버라이드
	public BoardVO(int bid, String title, String writer_id, String content, Date regdate, int hit, String files,
			boolean pub) {
		this.bid = bid;
		this.title = title;
		this.writer_id = writer_id;
		this.content = content;
		this.regdate = regdate;
		this.hit = hit;
		this.files = files;
		this.pub = pub;
	}

	// get, set


	public String getTitle() {
		return title;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public boolean getPub() {
		return pub;
	}

	public void setPub(boolean pub) {
		this.pub = pub;
	}

	public List<MultipartFile> getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(List<MultipartFile> uploadfile) {
		this.uploadfile = uploadfile;
	}
}

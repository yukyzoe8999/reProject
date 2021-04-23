package pp.board;

import java.util.Date;

public class CommentVO {
   private int cid;
   private int mid;
   private String comment;
   private String writerID;
   private Date regdate;
   
   public CommentVO() {
      
   }
   
   public CommentVO(int cid, int mid, String comment, String writerID, Date regdate) {
      this.cid = cid;
      this.mid = mid;
      this.comment = comment;
      this.writerID = writerID;
      this.regdate = regdate;
   }



   public int getCid() {
	return cid;
}

public void setCid(int cid) {
	this.cid = cid;
}

public int getMid() {
      return mid;
   }

   public void setMid(int mid) {
      this.mid = mid;
   }

   public String getComment() {
      return comment;
   }

   public void setComment(String comment) {
      this.comment = comment;
   }

   public String getWriterID() {
      return writerID;
   }

   public void setWriterID(String writerID) {
      this.writerID = writerID;
   }

   public Date getRegdate() {
      return regdate;
   }

   public void setRegdate(Date regdate) {
      this.regdate = regdate;
   }
   
   
   
}

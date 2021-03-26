package member;

import java.sql.Date;

public class VisitVO {
	private int id;
	private String author = null;
	private String content = null;
	private Date create_date = null;
	
	public VisitVO (String author, String content) {
		this.id = -1;
		this.author = author;
		this.content = content;
		this.create_date = null;
	}
	
	public VisitVO (int id, String author, String context, Date create_date) {
		this.id = id;
		this.author = author;
		this.content = context;
		this.create_date = create_date;
	}

	public int getId() {
		return id;
	}

//	시퀀스라 자동증가니까 수정 못하게
//	public void setId(int id) {
//		this.id = id;
//	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String context) {
		this.content = context;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
	
}

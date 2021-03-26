package member;

import java.sql.Date;

public class VisitVO {
	private int id;
	private String author = null;
	private String context = null;
	private Date create_date = null;
	
	public VisitVO (int id, String author, String context, Date create_date) {
		this.id = id;
		this.author = author;
		this.context = context;
		this.create_date = create_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
	
}

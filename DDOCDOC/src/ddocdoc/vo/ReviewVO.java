package ddocdoc.vo;

import java.io.Serializable;
import java.util.Date;
//import java.sql.Date;


public class ReviewVO implements Serializable{
	private String rv_num; //review num
	private String rv_title; //review title
	private String rv_writer; //review writer
	private String rv_content; //review content
	private String  rv_date; //review date
	private String rv_count; //review count
	private String cus_num; //customer number

	public ReviewVO() {}

	public ReviewVO(String rv_num, String rv_title, String rv_writer, String rv_content, String rv_date,
			String rv_count, String cus_num) {
		super();
		this.rv_num = rv_num;
		this.rv_title = rv_title;
		this.rv_writer = rv_writer;
		this.rv_content = rv_content;
		this.rv_date = rv_date;
		this.rv_count = rv_count;
		this.cus_num = cus_num;
	}

	public String getRv_num() {
		return rv_num;
	}

	public void setRv_num(String rv_num) {
		this.rv_num = rv_num;
	}

	public String getRv_title() {
		return rv_title;
	}

	public void setRv_title(String rv_title) {
		this.rv_title = rv_title;
	}

	public String getRv_writer() {
		return rv_writer;
	}

	public void setRv_writer(String rv_writer) {
		this.rv_writer = rv_writer;
	}

	public String getRv_content() {
		return rv_content;
	}

	public void setRv_content(String rv_content) {
		this.rv_content = rv_content;
	}

	public String getRv_date() {
		return rv_date;
	}

	public void setRv_date(String rv_date) {
		this.rv_date = rv_date;
	}

	public String getRv_count() {
		return rv_count;
	}

	public void setRv_count(String rv_count) {
		this.rv_count = rv_count;
	}

	public String getCus_num() {
		return cus_num;
	}

	public void setCus_num(String cus_num) {
		this.cus_num = cus_num;
	}

	@Override
	public String toString() {
		return "ReviewVO [rv_num=" + rv_num + ", rv_title=" + rv_title + ", rv_writer=" + rv_writer + ", rv_content="
				+ rv_content + ", rv_date=" + rv_date + ", rv_count=" + rv_count + ", cus_num=" + cus_num + "]";
	}

	

	
	
	
}
 
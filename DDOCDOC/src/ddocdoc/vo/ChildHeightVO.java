package ddocdoc.vo;

import java.io.Serializable;
import java.sql.Date;

public class ChildHeightVO implements Serializable{

	private String he_num;
	private Double he_height;
	private Date he_date;
	private String ch_num;
	
	public ChildHeightVO() {}
	
	public ChildHeightVO(Double he_height, Date he_date) {
		super();
		this.he_height = he_height;
		this.he_date = he_date;
	}
	public ChildHeightVO(String he_num, Double he_height) {
		super();
		this.he_num = he_num;
		this.he_height = he_height;
	}
	public ChildHeightVO(String he_num, Double he_height, Date he_date) {
		super();
		this.he_num = he_num;
		this.he_height = he_height;
		this.he_date = he_date;
	}
	
	public ChildHeightVO(String he_num, Double he_height, String ch_num, Date he_date) {
		super();
		this.he_num = he_num;
		this.he_height = he_height;
		this.ch_num = ch_num;
		this.he_date = he_date;
	}
	
	public Date getHe_date() {
		return he_date;
	}

	public void setHe_date(Date he_date) {
		this.he_date = he_date;
	}


	public String getHe_num() {
		return he_num;
	}

	public void setHe_num(String he_num) {
		this.he_num = he_num;
	}

	public Double getHe_height() {
		return he_height;
	}

	public void setHe_height(Double he_height) {
		this.he_height = he_height;
	}

	public String getCh_num() {
		return ch_num;
	}

	public void setCh_num(String ch_num) {
		this.ch_num = ch_num;
	}

	
}

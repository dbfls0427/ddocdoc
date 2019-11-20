package ddocdoc.vo;

import java.io.Serializable;
import java.sql.Date;

public class ChildVO implements Serializable {
	private String ch_num;
	private String ch_name;
	private int ch_age;
	private Date ch_birth;
	private String ch_gender;
	private String cus_num;
	
	public ChildVO() {}
	
	
	public ChildVO(String ch_num, String ch_name, int ch_age, Date ch_birth, String ch_gender, String cus_num) {
		super();
		this.ch_num = ch_num;
		this.ch_name = ch_name;
		this.ch_age = ch_age;
		this.ch_birth = ch_birth;
		this.ch_gender = ch_gender;
		this.cus_num = cus_num;
	}
	
	public String getCh_num() {
		return ch_num;
	}
	public void setCh_num(String ch_num) {
		this.ch_num = ch_num;
	}
	public String getCh_name() {
		return ch_name;
	}
	public void setCh_name(String ch_name) {
		this.ch_name = ch_name;
	}
	public int getCh_age() {
		return ch_age;
	}
	public void setCh_age(int ch_age) {
		this.ch_age = ch_age;
	}
	public Date getCh_birth() {
		return ch_birth;
	}
	public void setCh_birth(Date ch_birth) {
		this.ch_birth = ch_birth;
	}
	public String getCh_gender() {
		return ch_gender;
	}
	public void setCh_gender(String ch_gender) {
		this.ch_gender = ch_gender;
	}
	public String getCus_num() {
		return cus_num;
	}
	public void setCus_num(String cus_num) {
		this.cus_num = cus_num;
	}
	
	

	
	
	
}

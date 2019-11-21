package ddocdoc.vo;

import java.io.Serializable;
import java.sql.Date;

public class PresVO implements Serializable{
	private String pres_num;
	private Date pres_date;
	private int pres_count;
	private String cus_num;
	private String phar_num;
	private String hos_num;
	
	public String getPres_num() {
		return pres_num;
	}
	public void setPres_num(String pres_num) {
		this.pres_num = pres_num;
	}
	public Date getPres_date() {
		return pres_date;
	}
	public void setPres_date(Date pres_date) {
		this.pres_date = pres_date;
	}
	public int getPres_count() {
		return pres_count;
	}
	public void setPres_count(int pres_count) {
		this.pres_count = pres_count;
	}
	public String getCus_num() {
		return cus_num;
	}
	public void setCus_num(String cus_num) {
		this.cus_num = cus_num;
	}
	public String getPhar_num() {
		return phar_num;
	}
	public void setPhar_num(String phar_num) {
		this.phar_num = phar_num;
	}
	public String getHos_num() {
		return hos_num;
	}
	public void setHos_num(String hos_num) {
		this.hos_num = hos_num;
	}
	

	
}

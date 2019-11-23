package ddocdoc.vo;

import java.io.Serializable;
import java.sql.Date;

public class PresVO implements Serializable{
	private String pres_num;	// 처방전번호
	private Date pres_date;		// 발급일
	private int pres_count;		// 복용횟수
	private String cus_num;		// 고객번호
	private String hos_num;		// 병원번호
	private String hos_res_num; //예약번호
	private String pay_check; // 결제 여부
	
	public PresVO() {}

	public PresVO(String pres_num, Date pres_date, int pres_count, String cus_num, String hos_num, String hos_res_num,
			String pay_check) {
		super();
		this.pres_num = pres_num;
		this.pres_date = pres_date;
		this.pres_count = pres_count;
		this.cus_num = cus_num;
		this.hos_num = hos_num;
		this.hos_res_num = hos_res_num;
		this.pay_check = pay_check;
	}
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
	
	public String getHos_num() {
		return hos_num;
	}
	public void setHos_num(String hos_num) {
		this.hos_num = hos_num;
	}

	public String getHos_res_num() {
		return hos_res_num;
	}

	public void setHos_res_num(String hos_res_num) {
		this.hos_res_num = hos_res_num;
	}

	public String getPay_check() {
		return pay_check;
	}

	public void setPay_check(String pay_check) {
		this.pay_check = pay_check;
	}

	
	
	
}

package ddocdoc.vo;

import java.io.Serializable;
import java.sql.Date;

public class HosResVO implements Serializable {
	private String hos_res_num;		//병원예약번호
	private String hos_res_type;	//진료종류
	private String hos_res_sym;		//진료증상
	private String hos_res_memo;	//메모
	private Date hos_res_date;		//진료날짜
	private String hos_res_time;	//진료시간
	private String cus_num;			//고객번호
	private String hos_num;			//병원번호
	private String hos_acpt;		//병원예약접수
	
	public HosResVO() {}
	
	

	public HosResVO(String hos_res_num, String hos_res_type, String hos_res_sym, String hos_res_memo, Date hos_res_date,
			String hos_res_time, String cus_num, String hos_num, String hos_acpt) {
		super();
		this.hos_res_num = hos_res_num;
		this.hos_res_type = hos_res_type;
		this.hos_res_sym = hos_res_sym;
		this.hos_res_memo = hos_res_memo;
		this.hos_res_date = hos_res_date;
		this.hos_res_time = hos_res_time;
		this.cus_num = cus_num;
		this.hos_num = hos_num;
		this.hos_acpt = hos_acpt;
	}



	public HosResVO(String hos_res_num, String hos_res_type, String hos_res_sym, String hos_res_memo, Date hos_res_date,
			String hos_res_time, String cus_num, String hos_num) {
		super();
		this.hos_res_num = hos_res_num;
		this.hos_res_type = hos_res_type;
		this.hos_res_sym = hos_res_sym;
		this.hos_res_memo = hos_res_memo;
		this.hos_res_date = hos_res_date;
		this.hos_res_time = hos_res_time;
		this.cus_num = cus_num;
		this.hos_num = hos_num;
	}

	public String getHos_res_num() {
		return hos_res_num;
	}

	public void setHos_res_num(String hos_res_num) {
		this.hos_res_num = hos_res_num;
	}

	public String getHos_res_type() {
		return hos_res_type;
	}

	public void setHos_res_type(String hos_res_type) {
		this.hos_res_type = hos_res_type;
	}

	public String getHos_res_sym() {
		return hos_res_sym;
	}

	public void setHos_res_sym(String hos_res_sym) {
		this.hos_res_sym = hos_res_sym;
	}

	public String getHos_res_memo() {
		return hos_res_memo;
	}

	public void setHos_res_memo(String hos_res_memo) {
		this.hos_res_memo = hos_res_memo;
	}

	public Date getHos_res_date() {
		return hos_res_date;
	}

	public void setHos_res_date(Date hos_res_date) {
		this.hos_res_date = hos_res_date;
	}

	public String getHos_res_time() {
		return hos_res_time;
	}

	public void setHos_res_time(String hos_res_time) {
		this.hos_res_time = hos_res_time;
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



	public String getHos_acpt() {
		return hos_acpt;
	}



	public void setHos_acpt(String hos_acpt) {
		this.hos_acpt = hos_acpt;
	}
	
	
	
	
}

package ddocdoc.vo;

import java.sql.Date;

public class HospitalReserveVO {

	private String hos_res_num;
	private String hos_res_type;
	private String hos_res_sym;
	private String hos_res_memo;
	private Date hos_res_date;
	private String hos_res_time;
	private String cus_num;
	private String hos_num;
	

	public HospitalReserveVO() {}
	
	public HospitalReserveVO(String hos_res_num, String hos_res_type, String hos_res_sym, String hos_res_memo,
			String hos_res_time) {
		super();
		this.hos_res_num = hos_res_num;
		this.hos_res_type = hos_res_type;
		this.hos_res_sym = hos_res_sym;
		this.hos_res_memo = hos_res_memo;
		this.hos_res_time = hos_res_time;
	}
	public HospitalReserveVO(String hos_res_num, String hos_res_type, String hos_res_sym, String hos_res_memo,
			Date hos_res_date, String hos_res_time, String cus_num, String hos_num) {
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
	
	
}

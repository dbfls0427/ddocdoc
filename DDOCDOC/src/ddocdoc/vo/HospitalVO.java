package ddocdoc.vo;

import java.io.Serializable;

public class HospitalVO implements Serializable{
	private int seq;			//시퀀스
	private String hos_num;		//병원번호
	private String hos_name;	//병원이름
	private String hos_tel;		//병원전화번호
	private String hos_addr;	//병원주소
	private String hos_time;	//병원운영시간
	private String hos_info;	//병원정보
	private int hos_wait;		//병원대기번호
	private String hos_type;	//병원종류
	
	
	public HospitalVO() {}


	public HospitalVO(int seq, String hos_num, String hos_name, String hos_tel, String hos_addr, String hos_time,
			String hos_info, int hos_wait, String hos_type) {
		super();
		this.seq = seq;
		this.hos_num = hos_num;
		this.hos_name = hos_name;
		this.hos_tel = hos_tel;
		this.hos_addr = hos_addr;
		this.hos_time = hos_time;
		this.hos_info = hos_info;
		this.hos_wait = hos_wait;
		this.hos_type = hos_type;
	}



	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getHos_num() {
		return hos_num;
	}

	public void setHos_num(String hos_num) {
		this.hos_num = hos_num;
	}

	public String getHos_name() {
		return hos_name;
	}

	public void setHos_name(String hos_name) {
		this.hos_name = hos_name;
	}

	public String getHos_tel() {
		return hos_tel;
	}

	public void setHos_tel(String hos_tel) {
		this.hos_tel = hos_tel;
	}

	public String getHos_addr() {
		return hos_addr;
	}

	public void setHos_addr(String hos_addr) {
		this.hos_addr = hos_addr;
	}

	public String getHos_time() {
		return hos_time;
	}

	public void setHos_time(String hos_time) {
		this.hos_time = hos_time;
	}

	public String getHos_info() {
		return hos_info;
	}

	public void setHos_info(String hos_info) {
		this.hos_info = hos_info;
	}

	public int getHos_wait() {
		return hos_wait;
	}

	public void setHos_wait(int hos_wait) {
		this.hos_wait = hos_wait;
	}

	public String getHos_type() {
		return hos_type;
	}

	public void setHos_type(String hos_type) {
		this.hos_type = hos_type;
	}

	
}

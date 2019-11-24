package ddocdoc.vo;

import java.io.Serializable;

public class PharmacyVO implements Serializable{	
	private String phar_num;	//pharmacy number
	private String phar_name;	//pharmacy name
	private String phar_tel; 	//pharmacy tel
	private String phar_addr;	//pharmacy address
	private String phar_time;	//pharmacy time
	private String phar_info;	//pharmacy info
	private int phar_wait;	//pharmacy wait
	
	public PharmacyVO() {}	

	public PharmacyVO(String phar_num, String phar_name, String phar_tel, String phar_addr, String phar_time,
			String phar_info, int phar_wait) {
		super();
		this.phar_num = phar_num;
		this.phar_name = phar_name;
		this.phar_tel = phar_tel;
		this.phar_addr = phar_addr;
		this.phar_time = phar_time;
		this.phar_info = phar_info;
		this.phar_wait = phar_wait;
	}

	

	public PharmacyVO(String phar_num, String phar_name, String phar_tel, String phar_addr, String phar_time,
			String phar_info) {
		super();
		this.phar_num = phar_num;
		this.phar_name = phar_name;
		this.phar_tel = phar_tel;
		this.phar_addr = phar_addr;
		this.phar_time = phar_time;
		this.phar_info = phar_info;
	}

	public String getPhar_num() {
		return phar_num;
	}

	public void setPhar_num(String phar_num) {
		this.phar_num = phar_num;
	}

	public String getPhar_name() {
		return phar_name;
	}

	public void setPhar_name(String phar_name) {
		this.phar_name = phar_name;
	}

	public String getPhar_tel() {
		return phar_tel;
	}

	public void setPhar_tel(String phar_tel) {
		this.phar_tel = phar_tel;
	}

	public String getPhar_addr() {
		return phar_addr;
	}

	public void setPhar_addr(String phar_addr) {
		this.phar_addr = phar_addr;
	}

	public String getPhar_time() {
		return phar_time;
	}

	public void setPhar_time(String phar_time) {
		this.phar_time = phar_time;
	}

	public String getPhar_info() {
		return phar_info;
	}

	public void setPhar_info(String phar_info) {
		this.phar_info = phar_info;
	}

	public int getPhar_wait() {
		return phar_wait;
	}

	public void setPhar_wait(int phar_wait) {
		this.phar_wait = phar_wait;
	}
	
	

}

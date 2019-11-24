package ddocdoc.vo;

import java.io.Serializable;

public class PharResVO implements Serializable{

	private String phar_res_num;
	private String phar_res_time;
	private String phar_res_memo;
	private String cus_num;
	private String phar_num;
	
	public PharResVO() {}
	public String getPhar_res_num() {
		return phar_res_num;
	}

	public void setPhar_res_num(String phar_res_num) {
		this.phar_res_num = phar_res_num;
	}

	public String getPhar_res_time() {
		return phar_res_time;
	}

	public void setPhar_res_time(String phar_res_time) {
		this.phar_res_time = phar_res_time;
	}

	public String getPhar_res_memo() {
		return phar_res_memo;
	}

	public void setPhar_res_memo(String phar_res_memo) {
		this.phar_res_memo = phar_res_memo;
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

	
}

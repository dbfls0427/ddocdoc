package ddocdoc.vo;

public class ChildHeightVO {

	private String he_num;
	private int he_height;
	private String cus_num;
	
	public ChildHeightVO() {}
	
	public ChildHeightVO(String he_num, int he_height, String cus_num) {
		super();
		this.he_num = he_num;
		this.he_height = he_height;
		this.cus_num = cus_num;
	}

	public String getHe_num() {
		return he_num;
	}

	public void setHe_num(String he_num) {
		this.he_num = he_num;
	}

	public int getHe_height() {
		return he_height;
	}

	public void setHe_height(int he_height) {
		this.he_height = he_height;
	}

	public String getCus_num() {
		return cus_num;
	}

	public void setCus_num(String cus_num) {
		this.cus_num = cus_num;
	}

	
}

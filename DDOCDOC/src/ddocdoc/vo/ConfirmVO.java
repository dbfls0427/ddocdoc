package ddocdoc.vo;

public class ConfirmVO {
	private String confirmNum;
	private boolean check = false;
	private boolean finalCheck = false;
	public String getConfirmNum() {
		return confirmNum;
	}
	public void setConfirmNum(String confirmNum) {
		this.confirmNum = confirmNum;
	}
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	public boolean isFinalCheck() {
		return finalCheck;
	}
	public void setFinalCheck(boolean finalCheck) {
		this.finalCheck = finalCheck;
	}
	
	
}

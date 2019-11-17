package ddocdoc.action;

public class ActionForward {
	
	private boolean isRedirect; //dispatcher/redirect
	private String path; //어떤url로 경로를 알고싶다.
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

}

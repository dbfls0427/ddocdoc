package ddocdoc.action;

public class ActionForward {
	
	private boolean isRedirect; //dispatcher/redirect
	private String path; //�url�� ��θ� �˰�ʹ�.
	
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

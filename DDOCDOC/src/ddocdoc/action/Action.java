package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	
	//�޼����̸��� �Ȱ����ϴ°� ����->�׷��� �� ȣ���� �� �ִ�.
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response)throws Exception;
}
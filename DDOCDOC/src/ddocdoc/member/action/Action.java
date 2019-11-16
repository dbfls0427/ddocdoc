package ddocdoc.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	
	//메서드이름은 똑같이하는게 좋다->그래야 다 호출할 수 있다.
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response)throws Exception;
}

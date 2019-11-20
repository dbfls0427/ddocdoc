package ddocdoc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.loginSession.LoginSession;
import ddocdoc.service.CustomerService;
import ddocdoc.service.CustomerServiceImpl;
import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.HospitalVO;

public class ResListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CustomerService sc = CustomerServiceImpl.getInstance();
		
		String cus_num = ((CustomerVO)LoginSession.loginSession.getAttribute("customer")).getCus_num();
		
		
		
		List<HospitalResVO> list = sc.resList(cus_num);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getHos_num());
		}
		List<String> listName = sc.detailNameHospital(cus_num);
		for(int i = 0; i < listName.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		

		request.setAttribute("list", list);
		request.setAttribute("hosName", listName);
		
		forward.setPath("/hos_res/resList.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}

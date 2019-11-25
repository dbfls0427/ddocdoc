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
import ddocdoc.vo.PharResVO;

public class ResListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CustomerService sc = CustomerServiceImpl.getInstance();
		
		String cus_num = ((CustomerVO)LoginSession.loginSession.getAttribute("customer")).getCus_num();
		List<HospitalResVO> list = sc.resList(cus_num);
		List<String> listName = sc.detailNameHospital(cus_num);
		request.setAttribute("list", list);
		request.setAttribute("hosName", listName);
		
		List<PharResVO> pharList2 = sc.pharResList(cus_num);
		List<String> pharNameList2 =sc.detailNamePharmacy(cus_num);
		
		request.setAttribute("pharList", pharList2);
		request.setAttribute("pharNameList", pharNameList2);
		
		forward.setPath("/hos_res/resList.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}

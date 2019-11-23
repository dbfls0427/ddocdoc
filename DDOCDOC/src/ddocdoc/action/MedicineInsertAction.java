package ddocdoc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.loginSession.LoginSession;
import ddocdoc.service.HospitalService;
import ddocdoc.service.HospitalServiceImpl;
import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.PresDetailVO;

public class MedicineInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HospitalService service = HospitalServiceImpl.getInstance();
		
		int count = Integer.parseInt(request.getParameter("med_count"));
		String cus_num = ((CustomerVO)LoginSession.loginSession.getAttribute("customer")).getCus_num();
		String hos_res_num = request.getParameter("hos_res_num");
		String pres_num = request.getParameter("pres_num");
		System.out.println("mediaction 에서 : " + hos_res_num);
		System.out.println("mediaction pres_num 에서 : " + pres_num);
		PresDetailVO presDetail = new PresDetailVO();
		presDetail.setCus_num(cus_num);
		presDetail.setMed_num(request.getParameter("med_num"));
		presDetail.setMed_count(count);
		presDetail.setHos_res_num(hos_res_num);
		presDetail.setPres_num(pres_num);
		
		
		service.insertPreDetail(presDetail);
		
		List<PresDetailVO> list = service.presDetailList(pres_num);
		List<String> list2 = service.presDetailMedName(pres_num);
		
		request.setAttribute("medicine", presDetail);
		request.setAttribute("list", list);
		request.setAttribute("medName", list2);
		request.setAttribute("hos_res_num", hos_res_num);
		forward.setPath("presInsertForm.do");
		forward.setRedirect(false);
		
		
		return forward;
	}

}

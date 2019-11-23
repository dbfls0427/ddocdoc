package ddocdoc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.HospitalService;
import ddocdoc.service.HospitalServiceImpl;
import ddocdoc.vo.MedicineVO;
import ddocdoc.vo.PresVO;

public class PresInsertFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HospitalService service = HospitalServiceImpl.getInstance();
		
		
		
		PresVO pres = service.presDetail();
		String pres_num = pres.getPres_num();
		System.out.println("PresInsertFormAction에서 " + pres.getPres_num());
		
		
		String hos_res_num = request.getParameter("hos_res_num");
		
		System.out.println("insertForm에서 : " + hos_res_num);
		// 약 리스트
		List<MedicineVO> medicinevo = service.medicineList();
		request.setAttribute("medicinevo", medicinevo);
		request.setAttribute("hos_res_num", hos_res_num);
		request.setAttribute("pres_num", pres_num);
		
		forward.setPath("/pres/presInsertForm.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}

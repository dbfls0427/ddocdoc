package ddocdoc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.action.Action;
import ddocdoc.action.ActionForward;
import ddocdoc.action.HospitalDeleteAction;
import ddocdoc.action.HospitalInsertAction;
import ddocdoc.action.HospitalInsertFormAction;
import ddocdoc.action.HospitalListAction;
import ddocdoc.action.HospitalUpdateAction;
import ddocdoc.action.HospitalUpdateFormAction;
import ddocdoc.action.hospitalDetailAction;



@WebServlet("/hospital/*")
public class HospitalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public HospitalController() {
		super();
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()+10);
		System.out.println("command: "+command);
		
		Action action = null;
		ActionForward forward = null;
		
		
		if(command.equals("hospitalInsertForm.do")) {
			action = new HospitalInsertFormAction();
			try {
				forward = action.execute(request, response); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("hospitalInsert.do")) {
			action = new HospitalInsertAction();
			try {
				forward = action.execute(request, response); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("hospitalList.do")) {
			action = new HospitalListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("hospitalDetail.do")) {
			action = new hospitalDetailAction();
			try {
				forward = action.execute(request, response); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("hospitalUpdateForm.do")) {
			action = new HospitalUpdateFormAction();
			try {
				forward = action.execute(request, response); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("hospitalUpdate.do")) {
			action = new HospitalUpdateAction();
			try {
				forward = action.execute(request, response); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("hospitalDelete.do")) {
			action = new HospitalDeleteAction();
			try {
				forward = action.execute(request, response); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispacher =
						request.getRequestDispatcher(forward.getPath());
				dispacher.forward(request, response);
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
}


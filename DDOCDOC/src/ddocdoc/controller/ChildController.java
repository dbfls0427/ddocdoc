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
import ddocdoc.action.ChildDeleteAction;
import ddocdoc.action.ChildDetailAction;
import ddocdoc.action.ChildInsertAction;
import ddocdoc.action.ChildInsertFormAction;
import ddocdoc.action.ChildListAction;
import ddocdoc.action.ChildPleaseLoginAction;
import ddocdoc.action.ChildUpdateAction;
import ddocdoc.action.ChildUpdateFormAction;
import ddocdoc.action.LoginFormAction;

@WebServlet("/child/*")
public class ChildController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ChildController() {
		super();
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()+7);
		System.out.println("command: "+command);
		
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("childInsertForm.do")) {
			action = new ChildInsertFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("childInsert.do")) {
			action = new ChildInsertAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("childList.do")) {
			action = new ChildListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("childDetail.do")) {
			action = new ChildDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("childDelete.do")) {
			action = new ChildDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("childUpdateForm.do")) {
			action = new ChildUpdateFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("childUpdate.do")) {
			action = new ChildUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("childPleaseLogin.do")) {
			action = new ChildPleaseLoginAction();
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

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
import ddocdoc.action.PresInsertFormAction;

@WebServlet("/pres/*")
public class PresController extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	
	public PresController() {
		super();
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()+6);
		System.out.println("command: "+command);
		
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("presInsertForm.do")) {
			action = new PresInsertFormAction();
			
			try {
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("presInsert.do")) {
			
		}
		
		/*
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispacher =
						request.getRequestDispatcher(forward.getPath());
				dispacher.forward(request, response);
			}
		}
		*/
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

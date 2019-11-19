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
import ddocdoc.action.ConfirmAction;
import ddocdoc.action.DetailCustomerAction;
import ddocdoc.action.HeightAction;
import ddocdoc.action.HeightInsertFormAction;
import ddocdoc.action.HeightListAction;
import ddocdoc.action.JoinAction;
import ddocdoc.action.JoinFormAction;
import ddocdoc.action.LoginAction;
import ddocdoc.action.LoginFormAction;
import ddocdoc.action.LogoutAction;

@WebServlet("/Height/*")
public class ChildHeightController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChildHeightController() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String requestURI = request.getRequestURI();
    	String requestPath = request.getContextPath();
    	String command = requestURI.substring(requestPath.length() + 8);
    	System.out.println(command);
    	
    	Action action = null;
    	ActionForward forward = null;
    	
    	
    	if(command.equals("HeightInsertFormAction.do")) {
    		action = new HeightInsertFormAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("insertChildHeight.do")) {
    		action = new HeightAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("HeightList.do")) {
    		action = new HeightListAction();
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
    			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
    			dispatcher.forward(request, response);
    		}
    	}
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}

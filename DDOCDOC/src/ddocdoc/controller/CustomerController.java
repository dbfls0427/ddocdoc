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
import ddocdoc.action.JoinAction;
import ddocdoc.action.JoinFormAction;
import ddocdoc.action.LoginAction;
import ddocdoc.action.LoginFormAction;
import ddocdoc.action.LogoutAction;

@WebServlet("/Customer/*")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CustomerController() {
        super();
    }
    
    protected void customerProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String requestURI = request.getRequestURI();
    	String requestPath = request.getContextPath();
    	String command = requestURI.substring(requestPath.length() + 10);
    	
    	
    	Action action = null;
    	ActionForward forward = null;
    	
    	if(command.equals("join.do")) {
    		action = new JoinFormAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("joinAction.do")) {
    		action = new JoinAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("login.do")) {
    		System.out.println("경로: " + command);
    		action = new LoginAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("logout.do")) {
    		action = new LogoutAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("loginForm.do")) {
    		action = new LoginFormAction();
    		System.out.println("컨트롤러 : " + "폼");
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("detailCustomer.do")) {
    		action = new DetailCustomerAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("confirm.do")) {
    		action = new ConfirmAction();
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
		customerProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		customerProcess(request, response);
	}

}

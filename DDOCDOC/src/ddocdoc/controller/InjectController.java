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
import ddocdoc.action.HeightAction;
import ddocdoc.action.HeightInsertFormAction;
import ddocdoc.action.InjectDeleteAction;
import ddocdoc.action.InjectDetailAction;
import ddocdoc.action.InjectInsertAction;
import ddocdoc.action.InjectInsertFormAction;
import ddocdoc.action.InjectListAction;
import ddocdoc.action.InjectUpdateAction;


@WebServlet("/Inject/*")
public class InjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public InjectController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String requestURI = request.getRequestURI();
    	String requestPath = request.getContextPath();
    	String command = requestURI.substring(requestPath.length() + 8);
    	System.out.println(command);
    	
    	Action action = null;
    	ActionForward forward = null;
    	
    	
    	if(command.equals("InjectListAction.do")) {
    		action = new InjectListAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("InjectInsertFormAction.do")) {
    		action = new InjectInsertFormAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("InsertInjAction.do")) {
    		action = new InjectInsertAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("InjectDetailAction.do")) {
    		action = new InjectDetailAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("updateInjAction.do")) {
    		action = new InjectUpdateAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("deleteInjAction.do")) {
    		action = new InjectDeleteAction();
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

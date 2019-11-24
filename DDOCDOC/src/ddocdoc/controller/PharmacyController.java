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
import ddocdoc.action.PharmacyDeleteAction;
import ddocdoc.action.PharmacyDetailAction;
import ddocdoc.action.PharmacyInsertAction;
import ddocdoc.action.PharmacyInsertFormAction;
import ddocdoc.action.PharmacyListAction;
import ddocdoc.action.PharmacyUpdateAction;
import ddocdoc.action.PharmacyUpdateFormAction;


@WebServlet("/pharmacy/*")
public class PharmacyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PharmacyController() {
        super();
    }
    
    protected void PharmacyProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String requestURI = request.getRequestURI();
    	String requestPath = request.getContextPath();
    	String command = requestURI.substring(requestPath.length() + 10);
    	System.out.println("command: "+command);
    	
    	Action action = null;
    	ActionForward forward = null;
    	
    	if(command.equals("pharmacyInsertForm.do")) {
    		action = new PharmacyInsertFormAction(); 
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("pharmacyInsert.do")) {
    		action = new PharmacyInsertAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("pharmacyList.do")) {
    		action = new PharmacyListAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("pharmacyDetail.do")) {
    		action = new PharmacyDetailAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("pharmacyUpdateForm.do")) {
			action = new PharmacyUpdateFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("pharmacyUpdate.do")) {
    		action = new PharmacyUpdateAction();
    		try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("pharmacyDelete.do")) {
    		action = new PharmacyDeleteAction();
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
		PharmacyProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PharmacyProcess(request, response);
	}

}

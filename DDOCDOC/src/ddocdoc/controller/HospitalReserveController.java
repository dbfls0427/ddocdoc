package ddocdoc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.action.Action;
import ddocdoc.action.ActionForward;

/**
 * Servlet implementation class Hos_res_Controller
 */
@WebServlet("/Hos_res/*")
public class HospitalReserveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public HospitalReserveController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String requestURI = request.getRequestURI();
    	String requestPath = request.getContextPath();
    	String command = requestURI.substring(requestPath.length() + 9);
    	System.out.println(command);
    	System.out.println(request.getParameter("hos_name"));
    	Action action = null;
    	ActionForward forward = null;
    	
    	if(command.equals("hos_res.do")) {
    		
    	}
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}

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
import ddocdoc.action.ReviewDeleteAction;
import ddocdoc.action.ReviewDetailAction;
import ddocdoc.action.ReviewInsertAction;
import ddocdoc.action.ReviewInsertFormAction;
import ddocdoc.action.ReviewListAction;
import ddocdoc.action.ReviewUpdateAction;
import ddocdoc.action.ReviewUpdateFormAction;


@WebServlet("/review/*")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	  public ReviewController() {
	        super();
	    }
       
	protected void ReviewProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String requestURI = request.getRequestURI();
		String requestPath = request.getContextPath();
		String command = requestURI.substring(requestPath.length()+8);
		System.out.println("command: "+command);
		
		Action action = null;
		ActionForward forward = null;
		//http://localhost:8081/DDOCDOC/review/reviewInsertForm.do
		if(command.equals("reviewInsertForm.do")) {
			action = new ReviewInsertFormAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("insetForm됨!");
		}else if(command.equals("reviewInsert.do")) {
			System.out.println("aaa");
			action = new ReviewInsertAction();
			try {
				forward = action.execute(request,response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("insert됨!");
		}else if(command.equals("reviewList.do")) {
			action = new ReviewListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("list됨!");
		}else if(command.equals("reviewDetail.do")) {
			action = new ReviewDetailAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("detail됨!");
		}else if(command.equals("reviewUpdateForm.do")) {
			action = new ReviewUpdateFormAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("updateform됨!");
		}else if(command.equals("reviewUpdate.do")){
			action = new ReviewUpdateAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("update됨!");
		}else if (command.equals("reviewDelete.do")) {
			action = new ReviewDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("delete됨!");
		}
		
		if(forward!= null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
  
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewProcess(request, response);
	}
 
}

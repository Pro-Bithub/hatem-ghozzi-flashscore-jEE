package com.ibm.crud.controller;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import db.modeluser;
import db.modelfavori;
import db.modelmatch;



/**
 * Servlet implementation class LogoutController
 */
@WebServlet(description = "admin", urlPatterns = { "/admin" })
public class adminController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Constants that helps in this Controller
	private final String ERROR 			= "/views/error/error.jsp";
	private final String INDEX	= "/views/user/summary.jsp";
	private final String INDEXNOLOGIN 		= "/views/match/indexnologin.jsp";
	private final String ADD 		= "/views/user/add.jsp";
	private final String EDIT = "/views/user/edit.jsp";
	private final String EDITMATCH = "/views/match/edit.jsp";
	private final String ADDMATCH 		= "/views/match/add.jsp";
	private final String REDIRECTADMIN 		= "/views/authentication/redirectadmin.jsp";
	
	
	private modeluser musers = new modeluser();
	private modelmatch mmatch = new modelmatch();
	private modelfavori mfavori = new modelfavori();
public String	  login;

    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession(false);  
	        if(session!=null){  
	        	
	         login=(String)session.getAttribute("LOGIN");  
	        	String  password=(String)session.getAttribute("PASSWORD");  
	        
	        	final String type =musers.FetchTypeUserByNameandPassword(login,password);
	        	
	        	if(!musers.FetchUserByNameandPassword(login,password)) {
	        		
	        	getServletContext().getRequestDispatcher(ERROR).forward(request, response);	
	        	}
	        	if(!type.equals("admin")) {
	        		getServletContext().getRequestDispatcher(ERROR).forward(request, response);	
	        	}
	        	
	        
	        } else {
	        	
	        	getServletContext().getRequestDispatcher(ERROR).forward(request, response);	
	        }
	    
		this.doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view=null;
		final String action = (String) request.getParameter("action");
		if(null==action) {
			
			int iduser=musers.fetchuserbyname(login);
			//mfavori.fetchallfavori(iduser);
			musers.fetchalluser();
			
			request.setAttribute("users",musers.users);
		

			// Go ahead...
			view = request.getRequestDispatcher(INDEX);
			
		}else {
			if(action.equals("add"))
			 view = request.getRequestDispatcher(ADD);
			else if(action.equals("save")) {
				final String login = (String) request.getParameter("login");
				final String password = (String) request.getParameter("password");
				if(musers.insertUser(login,password))
				view = request.getRequestDispatcher(REDIRECTADMIN);
				else
					view = request.getRequestDispatcher(ADD);
			}else if(action.equals("delete")) {
				final String userid = (String) request.getParameter("userid");
				if(musers.deleteuser(Integer.parseInt(userid)))
					view = request.getRequestDispatcher(REDIRECTADMIN);
					else
						view = request.getRequestDispatcher(REDIRECTADMIN);
			}else if(action.equals("edit")) {
				final String userid = (String) request.getParameter("userid");
				musers.fetchuserbyid(Integer.parseInt(userid) );
				request.setAttribute("userEdit", musers.userbyuserid);
		
				 view = request.getRequestDispatcher(EDIT);
			}
				 else if(action.equals("update")) {
						final String login = (String) request.getParameter("login");
						final String password = (String) request.getParameter("password");
						final String type = (String) request.getParameter("type");
						final String userid = (String) request.getParameter("userid");
						if(musers.updateUser(login,password,type,Integer.parseInt(userid)))
							view = request.getRequestDispatcher(REDIRECTADMIN);
							else
								view = request.getRequestDispatcher(REDIRECTADMIN);	 
				 }
			
			
			
		}
		final String match = (String) request.getParameter("match");
	if(null==match ) {
		if(null==action ) {
			mmatch.fetchallmatch();
	    	request.setAttribute("matchs", mmatch.matchs);
				
				
			

				// Go ahead...
	 	view = request.getRequestDispatcher(INDEX);
		}
	
	
			
		}else {
			if(match.equals("add")) {
				 view = request.getRequestDispatcher(ADDMATCH);
			}
				
			
			else if(match.equals("delete")) {
				final String idmatch = (String) request.getParameter("idmatch");
				if(mmatch.deletematch(Integer.parseInt(idmatch)))
					view = request.getRequestDispatcher(REDIRECTADMIN);
					else
						view = request.getRequestDispatcher(REDIRECTADMIN);
		}
			else if(match.equals("save")) {
				final String statue = (String) request.getParameter("statue");
				final String nameequipeone = (String) request.getParameter("nameequipeone");
				final String nameequipetow = (String) request.getParameter("nameequipetow");
				if(mmatch.insertMatch(statue,nameequipeone,nameequipetow))
				view = request.getRequestDispatcher(REDIRECTADMIN);
				else
					view = request.getRequestDispatcher(ADD);
			}
			else if(match.equals("edit")) {
				final String idmatch = (String) request.getParameter("idmatch");
				mmatch.fetchmatchbyid(Integer.parseInt(idmatch) );
				request.setAttribute("matchEdit", mmatch.matchbyidmatch);
		
				 view = request.getRequestDispatcher(EDITMATCH);
			}else if(match.equals("update")) {
					   
						final String idmatch = (String) request.getParameter("idmatch");
			
						final String statue = (String) request.getParameter("statue");
						final String scoreequipeone = (String) request.getParameter("scoreequipeone");
						final String scoreequipetwo = (String) request.getParameter("scoreequipetwo");
						final String nameequipeone = (String) request.getParameter("nameequipeone");
						final String nameequipetow = (String) request.getParameter("nameequipetow");
						if(mmatch.updateMatch(nameequipetow,nameequipeone,Integer.parseInt(scoreequipetwo),Integer.parseInt(scoreequipeone),statue,Integer.parseInt(idmatch)))
							view = request.getRequestDispatcher(REDIRECTADMIN);
							else
								view = request.getRequestDispatcher(REDIRECTADMIN);	 
				 }
			
		}
	
		
		view.forward(request, response);
	}
	

}
package com.ibm.crud.controller;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.Cookie;
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
@WebServlet(description = "Match ", urlPatterns = { "/match" })
public class match extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Constants that helps in this Controller
//	private final String ERROR 			= "/views/error/error.jsp";
	private final String INDEXLOGIN 	= "/views/match/indexlogin.jsp";
	private final String INDEXNOLOGIN 		= "/views/match/indexnologin.jsp";
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
	        
	        
	        	
	        	if(!musers.FetchUserByNameandPassword(login,password)) {
	        		mmatch.fetchallmatch();
		        	request.setAttribute("matchs", mmatch.matchs);	
	        	getServletContext().getRequestDispatcher(INDEXNOLOGIN).forward(request, response);	
	        	}
	        
	        } else {
	        	
	        	mmatch.fetchallmatch();
	        	request.setAttribute("matchs", mmatch.matchs);
	        	getServletContext().getRequestDispatcher(INDEXNOLOGIN).forward(request, response);	
	        }
	    
		this.doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("login", login);
		
		int iduser=musers.fetchuserbyname(login);
		mfavori.fetchallfavori(iduser);
	
		request.setAttribute("favoris", mfavori.matchfavoris);
	
		if(request.getParameter("search")!=null)
    	{
    		final String search = (String) request.getParameter("search");
    		request.setAttribute("searchmatchs", search);
    		mmatch.fetchallmatchbysearch(search);
    		
    	}else {
    		mmatch.fetchallmatch();
    		
    		
    	}
    	
		request.setAttribute("matchs", mmatch.matchs);
		
		// Go ahead...
		RequestDispatcher view = request.getRequestDispatcher(INDEXLOGIN);
		view.forward(request, response);
	}
	

}
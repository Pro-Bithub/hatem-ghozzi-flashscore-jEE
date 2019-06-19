package com.ibm.crud.controller;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.modeluser;

/**
 * Servlet implementation class AuthenticationController
 */
@WebServlet(description = "User's Validation (register )", urlPatterns = { "/authentication/register" })
public class register extends HttpServlet {
	private static final long serialVersionUID = -717103814686488261L;

	// Constants that helps in this Controller
	private final String ERROR 			= "/views/error/error.jsp";
	private final String LOGIN_FAILED 	= "/views/authentication/register.jsp";
	private final String REDIRECT 		= "/views/authentication/redirect.jsp";
	private final String REDIRECTADMIN 		= "/views/authentication/redirectadmin.jsp";
	// UserDao, it will help to work on MySQL.
	
	private modeluser musers = new modeluser();

	/**
	 * Constructor default, <code>com.ibm.crud.controller.AuthenticationController</code>
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Getting login and password from request
		final String LOGIN = (String) request.getParameter("login");
		final String PASSWORD = (String) request.getParameter("password");
		final String CONFIRM = (String) request.getParameter("confirm");

		// Next JSP that will be forwarded
		String nextJSP = null;

	
		
	 		
		//check connection
		if(!musers.cnx.isTrying()) {
			request.setAttribute("error", musers.cnx.getMsg());
			getServletContext().getRequestDispatcher(ERROR).forward(request, response);	
	     }
		//check session
	
		
		  HttpSession session=request.getSession(false);  
	        if(session!=null){  
	        	
	        	String	  login=(String)session.getAttribute("LOGIN");  
	        	String  password=(String)session.getAttribute("PASSWORD");  
	         
	        	if(musers.FetchUserByNameandPassword(login,password)) {
	        		 String type =musers.FetchTypeUserByNameandPassword(LOGIN,PASSWORD);
					if(type.equals("admin"))
						getServletContext().getRequestDispatcher(REDIRECTADMIN).forward(request, response);	
					else {
			        	getServletContext().getRequestDispatcher(REDIRECT).forward(request, response);	
					}

	        	}
	        
	        } 
	        
	 
		// Let's try to validate login and password
		try {
			musers.fetchalluser();
		
			
			

			// If user is null, go back and alert the user
			if(null == LOGIN && null==PASSWORD  && null ==CONFIRM ||!CONFIRM.equals(PASSWORD)) {
				// Go to login failed
				nextJSP = LOGIN_FAILED;
			}else {

			
				if(musers.FetchUserByNameandPassword(LOGIN,PASSWORD))
				{
					nextJSP = LOGIN_FAILED;
					
					
					
				}else {
					if(musers.insertUser(LOGIN,PASSWORD)) {
						HttpSession sessionset = request.getSession(true);
						sessionset.setAttribute("LOGIN", LOGIN);
						sessionset.setAttribute("PASSWORD", PASSWORD);
						sessionset.setAttribute("TYPE", "user");
					
					}else {
						nextJSP = LOGIN_FAILED;
					}
					
			 
					
				}
			
			}
			
			
		
			
			
		// If appears any issues, let's show it for our users from this web app
		} catch (Exception e) {
		
			request.setAttribute("error", e.getMessage());

			getServletContext().getRequestDispatcher(ERROR).forward(request, response);
		}

		// Redirect the page...
		getServletContext().getRequestDispatcher((null == nextJSP) ? REDIRECT : nextJSP).forward(request, response);
	}
}
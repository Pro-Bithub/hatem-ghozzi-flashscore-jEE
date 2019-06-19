package com.ibm.crud.controller;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.ibm.crud.dao.UserDao;
//import com.ibm.crud.model.User;

import db.modeluser;

/**
 * Servlet implementation class AuthenticationController
 */
@WebServlet(description = "User's Validation (login and password)", urlPatterns = { "/authentication/login" })
public class AuthenticationController extends HttpServlet {
	private static final long serialVersionUID = -717103814686488261L;

	// Constants that helps in this Controller
	private final String ERROR 			= "/views/error/error.jsp";
	private final String LOGIN_FAILED 	= "/views/authentication/loginFailed.jsp";
	private final String REDIRECT 		= "/views/authentication/redirect.jsp";
	private final String REDIRECTADMIN 		= "/views/authentication/redirectadmin.jsp";
	// UserDao, it will help to work on MySQL.
	
	private modeluser musers = new modeluser();

	/**
	 * Constructor default, <code>com.ibm.crud.controller.AuthenticationController</code>
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticationController() {
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
	        		final String type =musers.FetchTypeUserByNameandPassword(LOGIN,PASSWORD);
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
			request.setAttribute("userss", musers.users);
			
			

			// If user is null, go back and alert the user
			if(null == LOGIN && null==PASSWORD ) {
				// Go to login failed
				nextJSP = LOGIN_FAILED;
			}

			// If user is NOT null, go ahead
			else {
				request.setAttribute("name", LOGIN);
				request.setAttribute("password", PASSWORD);
				request.setAttribute("test",musers.FetchUserByNameandPassword(LOGIN,PASSWORD));
			
				if(!musers.FetchUserByNameandPassword(LOGIN,PASSWORD))
				{
					nextJSP = LOGIN_FAILED;
				}else {
					// Let's the save user in session because we will 
					// use it on the future
			 
				
					final String type =musers.FetchTypeUserByNameandPassword(LOGIN,PASSWORD);
					if(type.equals("NOUSER"))
						nextJSP = LOGIN_FAILED;
					else {
						HttpSession sessionset = request.getSession(true);
						sessionset.setAttribute("LOGIN", LOGIN);
						sessionset.setAttribute("PASSWORD", PASSWORD);
						sessionset.setAttribute("TYPE", type);
					}
				}
			
			}
			
		
			
			
		// If appears any issues, let's show it for our users from this web app
		} catch (Exception e) {
			e.printStackTrace();
			getServletContext().getRequestDispatcher(ERROR).forward(request, response);
		}

		// Redirect the page...
		getServletContext().getRequestDispatcher((null == nextJSP) ? REDIRECT : nextJSP).forward(request, response);
	}
}
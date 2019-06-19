package com.ibm.crud.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet(description = "Logout ", urlPatterns = { "/logout" })
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 5979914333791112016L;

	// Constants that helps in this Controller
	private final String LOGIN = "/views/authentication/loginFailed.jsp";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutController() {
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
		// STOP CACHE-ing
		response.setHeader("Cache-Control", "must-revalidate"); 
		response.setHeader("Cache-Control", "no-cache"); 
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma","no-cache"); //HTTP 1.0
		response.setDateHeader ("Expires", -1); //prevents caching at the proxy server

		// Clean the cookies from browser
		Cookie[] cookielist = request.getCookies();
		if (cookielist!= null) {
			for (int i = 0; i < cookielist.length; i++) {
				cookielist[i].setMaxAge(-1);
				cookielist[i].setValue(null);
				response.addCookie(cookielist[i]);
			}
		}

		// Kill the session
		HttpSession session = request.getSession(true);
		session.invalidate();
		
		// Go ahead...
		RequestDispatcher view = request.getRequestDispatcher(LOGIN);
		view.forward(request, response);
	}
}
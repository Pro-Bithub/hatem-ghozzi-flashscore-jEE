package com.ibm.crud.controller;

import java.io.IOException;



//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
///import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
///import javax.servlet.http.HttpSession;
import db.modeluser;
///import db.modelmatch;
import db.modelfavori;

import java.io.PrintWriter;



/**
 * Servlet implementation class LogoutController
 */
@WebServlet(description = "saveIt", urlPatterns = { "/saveIt" })
public class SaveData extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private modeluser musers = new modeluser();
	private modelfavori mfavori = new modelfavori();
	/**
	 * 
	 */

    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String matchid = request.getParameter("idmatch");
		String favorilist = request.getParameter("favorilist");
		PrintWriter out = response.getWriter();
		int iduser=musers.fetchuserbyname(username);
		if(favorilist.equals("unfavori")) {
			Boolean trysunfavori=mfavori.deletematchbyiduser(Integer.parseInt(matchid) ,iduser);
		    out.print("trysunfavori successfully....!!"+trysunfavori);
		}
		
		else if (favorilist.equals("favori")) {
			Boolean trysfavori=mfavori.insertmatchbyiduser(Integer.parseInt(matchid) ,iduser);
			 out.print("trysfavori successfully....!!"+trysfavori);
		}
		
		
	 
		
	
		
	}

	

}
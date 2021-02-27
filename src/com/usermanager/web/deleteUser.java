package com.usermanager.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usermanager.dao.User_DAO;

/**
 * Servlet implementation class deleteUser
 */
public class deleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int sr_no = Integer.parseInt(request.getParameter("id"));
		
		int i = User_DAO.delete(sr_no);
		
		if (i == 1) {
			out.print("<p align=\"center\">User Deleted</p>");
			request.getRequestDispatcher("/index.jsp").include(request, response);
		} else {
			out.print("<p align=\"center\">Failed</p>");
			request.getRequestDispatcher("/index.jsp").include(request, response);
		}
		
	}

}

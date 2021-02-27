package com.usermanager.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usermanager.dao.User_DAO;
import com.usermanager.modal.User;

/**
 * Servlet implementation class updateUser
 */
public class updateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		User user = new User();
		
		String name = request.getParameter("user_name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String dob = request.getParameter("dob");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		long number = Long.parseLong(request.getParameter("number"));
		int sr_no = Integer.parseInt(request.getParameter("sr_no"));
		
		user.setName(name);
		user.setEmail(email);
		user.setAddress(address);
		user.setDob(dob);
		user.setGender(gender);
		user.setPassword(password);
		user.setNumber(number);
		user.setSr_no(sr_no);
		
		int i = User_DAO.update(user);
		
		if (i == 1) {
			out.print("Details Updated");
			request.getRequestDispatcher("/index.jsp").include(request, response);
		} else {
			out.print("Update Failed");
			request.getRequestDispatcher("/index.jsp").include(request, response);
		}
		
		
		
		
	}

}

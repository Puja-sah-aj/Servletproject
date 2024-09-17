package com.register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Dbconnect;

public class RegisterServlet extends HttpServlet{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Dbconnect dbconnect;
	
	public RegisterServlet() {
		super();
		dbconnect = new Dbconnect();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String contact = req.getParameter("contact");
		String password = req.getParameter("password");
		
		try {
			dbconnect.Saveuser(name, email, address, contact, password);
			//out.println("registration sucessfully");
			RequestDispatcher rd = req.getRequestDispatcher("/login.html");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}


	}
	

}

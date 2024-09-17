package com.login;

import java.io.IOException;
import java.io.ObjectInputFilter.Status;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		
		if(validateuser(email, password)) {
			out.print("login sucessfully");
		}else {
			out.println("login not sucessfully");
			
		}
	}
	
	
	private boolean validateuser(String email,String password) {
		boolean br = false;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/puja","root","Puja2002");
			
			String sql = "SELECT * FROM register WHERE email = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				br = true;
			}
			
			
			rs.close();
			ps.close();
			conn.close();
				
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return br;
		
	}

}

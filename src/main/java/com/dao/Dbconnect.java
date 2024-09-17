package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dbconnect {
	public Dbconnect() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/puja","root","Puja2002");
	}
	public void Saveuser(String name,String email,String address,String contact,String password) {
		String sql = "insert into register(name,email,address,contact,password) values(?,?,?,?,?)";
		try {
			Connection conn = getConnection();
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, name);
			pre.setString(2, email);
			pre.setString(3, address);
			pre.setString(4, contact);
			pre.setString(5, password);
			
			int i = pre.executeUpdate();
			if(i>0) {
				System.out.println("register sucessfully");
			}
			else {
				System.out.println("register not sucessfully");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
//	public static void main(String[] arr) {
//		Dbconnect db = new Dbconnect();
//		String name = "puja";
//		String email = "sahpuja234@gmail.com";
//		String address = "nepal";
//		String contact = "7903407231";
//		String password = "1452";
//		db.Saveuser(name, email, address, contact, password);
	//}

}

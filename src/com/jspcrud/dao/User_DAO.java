package com.jspcrud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jspcrud.modal.User;

public class User_DAO {
	/*
	 table = crud_user
	 */
	
//	method to get the connection 
	public static Connection gerConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
//	method to insert the user data into table
//	this method gets the values from the modal class and after invocation it inserts the user data into the database
	public static int insert(User user) {
		int i = 0;
		try {
			Connection con = User_DAO.gerConnection();
			PreparedStatement ps = con.prepareStatement("insert into crud_user values(?,?,?,?,?)");
			ps.setInt(1, user.getSr_no());
			ps.setString(2, user.getName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setLong(5, user.getNumber());
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
//	method to delete the user
//	this method gets the sr_no from the modal and after invocation it deletes the user information from database
	public static int delete(User user) {
		int i = 0;
		try {
			Connection con = User_DAO.gerConnection();
			PreparedStatement ps = con.prepareStatement("delete crud_user where sr_no = ?");
			ps.setInt(1, user.getSr_no());
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
//	method to update the user details
//	this method gets the values from the modal class and update the user details form into the database
	public static int update(User user) {
		int i = 0;
		try {
			Connection con = User_DAO.gerConnection();
			PreparedStatement ps = con.prepareStatement("update crud_user set name = ?, email = ?, password = ?, mobile_number = ? where sr_no = ?");
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setLong(4, user.getNumber());
			ps.setInt(5, user.getSr_no());
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
//	method to retrieve the user by name
//	this method will get the name from the modal and return the users with the same name after invocation
	public static List<User> users_name() {
		List<User> users = new ArrayList<User>();
		try {
			User user_set =new User();
			Connection con = User_DAO.gerConnection();
			PreparedStatement ps = con.prepareStatement("select * from crud_user where name = ?");
			ps.setString(1, user_set.getName());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user =new User();
				user.setSr_no(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setNumber(rs.getLong(5));
				
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
//	method to retrieve the whole table from the database
//	this method will set the whole table into the list and get all the user data from the database
	public static List<User> users() {
		List<User> users = new ArrayList<User>();
		try {
			Connection con = User_DAO.gerConnection();
			PreparedStatement ps = con.prepareStatement("select * from crud_user");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user =new User();
				user.setSr_no(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setNumber(rs.getLong(5));
				
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
}

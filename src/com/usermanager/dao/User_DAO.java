package com.usermanager.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.usermanager.modal.User;

public class User_DAO {
	/*
	 table = umadmin_supreme_begawo			temporary
	 create table umadmin_supreme_begawo(sr_no number(10), name varchar2(100), email varchar2(100), address varchar2(200), dob varchar2(15), gender varchar2(10), password varchar2(200), mobile_number number(10));
	 we have to remove @gamil.com to create the table
	 max length of the table name should be 30 characters
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
			PreparedStatement ps = con.prepareStatement("insert into umadmin_supreme_begawo values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, user.getSr_no());
			ps.setString(2, user.getName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getAddress());
			ps.setString(5, user.getDob());
			ps.setString(6, user.getGender());
			ps.setString(7, user.getPassword());
			ps.setLong(8, user.getNumber());
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
//	method to retrieve the user
//	this method gets the user data from the modal class and after invocation it retrieves the user data from database
	public static User retrieveUser(int sr_no) {
		User user = new User();
		try {
			Connection con = User_DAO.gerConnection();
			PreparedStatement ps = con.prepareStatement("select * from umadmin_supreme_begawo where sr_no = ?");
			ps.setInt(1, sr_no);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user.setSr_no(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setAddress(rs.getString(4));
				user.setDob(rs.getString(5));
				user.setGender(rs.getString(6));
				user.setPassword(rs.getString(7));
				user.setNumber(rs.getLong(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
//	method to delete the user
//	this method gets the sr_no from the modal and after invocation it deletes the user information from database
	public static int delete(int sr_no) {
		int i = 0;
		try {
			Connection con = User_DAO.gerConnection();
			PreparedStatement ps = con.prepareStatement("delete umadmin_supreme_begawo where sr_no = ?");
			ps.setInt(1, sr_no);
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
			PreparedStatement ps = con.prepareStatement("update umadmin_supreme_begawo set name = ?, email = ?, address = ?, dob = ?, gender = ?, password = ?, mobile_number = ? where sr_no = ?");
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getAddress());
			ps.setString(4, user.getDob());
			ps.setString(5, user.getGender());
			ps.setString(6, user.getPassword());
			ps.setLong(7, user.getNumber());
			ps.setInt(8, user.getSr_no());
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
//	method to retrieve the user by name
//	this method will get the name from the modal and return the users with the same name after invocation
	public static List<User> users_name(String name) {
		List<User> users = new ArrayList<User>();
		try {
			Connection con = User_DAO.gerConnection();
			PreparedStatement ps = con.prepareStatement("select * from umadmin_supreme_begawo where name = ?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user =new User();
				user.setSr_no(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setAddress(rs.getString(4));
				user.setDob(rs.getString(5));
				user.setGender(rs.getString(6));
				user.setPassword(rs.getString(7));
				user.setNumber(rs.getLong(8));
				
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
			PreparedStatement ps = con.prepareStatement("select * from umadmin_supreme_begawo");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user =new User();
				user.setSr_no(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setAddress(rs.getString(4));
				user.setDob(rs.getString(5));
				user.setGender(rs.getString(6));
				user.setPassword(rs.getString(7));
				user.setNumber(rs.getLong(8));
				
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
}

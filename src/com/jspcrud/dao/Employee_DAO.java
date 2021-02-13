package com.jspcrud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jspcrud.model.Employee;

public class Employee_DAO {
	
//	method to get JDBC connection
	protected static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
//	method to insert the employee's data into table
	public static int insert(Employee emp) {
		int i = 0;
		int eno = 0;
		try {
			Connection connection = Employee_DAO.getConnection();
			
//			query to get max eno from table
			PreparedStatement ps_max_eno = connection.prepareStatement("select max(eno) from emp");
			ResultSet rs_max_eno = ps_max_eno.executeQuery();
			if (rs_max_eno.next()) {
				eno = rs_max_eno.getInt(1);
				eno++;
				
//				query to get insert employee into table
				PreparedStatement ps = connection.prepareStatement("insert into emp values(?,?,?");
				ps.setInt(1, eno);
				ps.setString(2, emp.getEname());
				ps.setDouble(3, emp.getSalary());
				i = ps.executeUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
//	method to retrieve the employee's data from table by eno
	public static Employee retrieve(int eno) {
		Employee emp = null;
		try {
			Connection connection = Employee_DAO.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from emp where eno = ?");
			ps.setInt(1, eno);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				emp.setEno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setEname(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
	
//	method to update the emoloyee's data into table
	public static int update(Employee emp) {
		int i = 0;
		try {
			Connection connection = Employee_DAO.getConnection();
			PreparedStatement ps = connection.prepareStatement("update emp set ename = ?, salary = ? where eno = ?");
			ps.setString(1, emp.getEname());
			ps.setDouble(2, emp.getSalary());
			ps.setInt(3, emp.getEno());
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
//	method to delete the employee's data from table
	public static int delete(Employee emp) {
		int i = 0;
		try {
			Connection connection = Employee_DAO.getConnection();
			PreparedStatement ps = connection.prepareStatement("delete emp where eno = ?");
			ps.setInt(1, emp.getEno());
			i = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
//	method to retrieve the complete employee's table
	public static List<Employee> retrirvetable() {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			Connection connection = Employee_DAO.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from emp");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setEno(rs.getInt(1));
				employee.setEname(rs.getString(1));
				employee.setSalary(rs.getDouble(3));
				employees.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}
		
}

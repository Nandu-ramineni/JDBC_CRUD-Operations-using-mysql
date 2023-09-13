package com.jdbc;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.*;

public class Database {

	String url, uname, pass, db, query;
	Connection con;

	public Database(String url, String uname, String pass) throws SQLException {
		this.url = url;
		this.uname = uname;
		this.pass = pass;
		con = DriverManager.getConnection(url, uname, pass);

	}

	public void createDatabase(String db) throws SQLException {
		this.db = db;
		query = "create database if not exists " + this.db;

		Statement st = con.createStatement();
		st.executeUpdate(query);
		System.out.println(this.db +" database created");
	}

	public void createTable(String table) throws SQLException {
		url += db;
		con = DriverManager.getConnection(url, uname, pass);

		query = "create table if not exists " + table + "(" + "Em_Id integer primary key," + "Em_Name varchar(40),"
				+ "Salary float," + "Company varchar(20))";

		Statement st = con.createStatement();
		st.executeUpdate(query);
		System.out.println(table +" table created");

	}

	public void insertVar(String table, Employee emp) throws SQLException {

		this.query = "insert into " + table + " values(?, ?, ?, ?)";

		con = DriverManager.getConnection(url, uname, pass);

		PreparedStatement st = con.prepareStatement(query);
		 
		 st.setInt(1, emp.Em_Id); 
		 st.setString(2, emp.Em_Name); 
		 st.setDouble(3,emp.Salary); 
		 st.setString(4, Employee.Company); 
		 int row = st.executeUpdate();
		 System.out.println(row + " Row's inserted successfully.");
		 
	}
		 
	public void delete(String table, int Em_Id) throws SQLException {
		con = DriverManager.getConnection(url, uname, pass);

		this.query = "delete from " + table + " where Em_Id=" + Em_Id;
		Statement st = con.createStatement();
		
		int row_Deleted = st.executeUpdate(query);
		System.out.println(row_Deleted + " Row's deleted successfully.");
		con.close();

	}

	public void update(String table, int Em_Id, Double salary_u) throws SQLException {

		con = DriverManager.getConnection(url, uname, pass);

		this.query = "update "+ table +" set Salary = ? where Em_Id = ?";

		PreparedStatement st = con.prepareStatement(query);

		st.setDouble(1, salary_u);
		st.setInt(2, Em_Id);
		
		int row_Updated = st.executeUpdate();
		
		System.out.println(row_Updated + " Row's updated successfully.");
		con.close();

	}

	public void retreive(String table) throws SQLException {
		con = DriverManager.getConnection(url, uname, pass);

		this.query = "select * from " + table;

		Statement st = con.createStatement();

		ResultSet result = st.executeQuery(query);

		while (result.next()) {
			System.out.print("Employee_Id: " + result.getInt(1) + " ");
			System.out.print("Employee_Name: " + result.getString(2) + " ");
			System.out.println("Employee_Salary: "+result.getDouble(3) + " ");
			System.out.println("Company_Name: "+result.getString(4) + " ");
		}
		con.close();

	}

}
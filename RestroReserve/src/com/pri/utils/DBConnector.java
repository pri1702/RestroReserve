package com.pri.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DBConnector {
	
	private static final String USER = "root";
	private static final String PASSWORD = "pirpiri";
	private static final String DBURL = "jdbc:mysql://localhost:3306/restaurant";
	
	//load Driver
	static{
		try{
		Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}
	
	/*
	 * Get connection
	 * @return
	 */
	public static Connection connect(){
		
		Connection conn = null;
		try{
		conn=DriverManager.getConnection(DBURL,USER,PASSWORD);
		System.out.println("Successful!");
		}
		catch(SQLException e){
			e.printStackTrace();
			System.err.println(e.getMessage());
			
		}
		
		return conn;
	}
	
	public static void closeResources(PreparedStatement ps,ResultSet rs,Connection conn){
	try{
		if(ps!=null){
			ps.close();
		}
		if(rs!=null){
			rs.close();
		}
		if(conn!=null){
			conn.close();
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	}
	public static void main(String[] args){
		DBConnector.connect();
	}
}

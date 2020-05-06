package com.paf.PafProj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
protected Connection con;

	public DBConnection() 
	{

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/payment?useTimezone=true&serverTimezone=UTC", "root", "");
			con = conn;

			System.out.print("Database is connected !");
			
		} catch (Exception e) {
			System.out.print("Do not connect to DB - Error: " + e);
		}

	}
	  
	  public ResultSet GtResultSet(String query) throws SQLException { 
		  Statement Stat =  con.createStatement(); 
		  ResultSet Result = Stat.executeQuery(query); 
		  return Result; }
	  
	  public PreparedStatement GtPrepStatement(String query) throws SQLException {
	  PreparedStatement PrepStat = con.prepareStatement(query);
	  return PrepStat; }
	
}

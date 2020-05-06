package com.paf.PafProj;

import java.sql.*;
import java.util.ArrayList;


public class PaymentHadler {

	//Select All
	public String SelectAll() throws Exception
	{
		String output = ""; 
		String Query = "SELECT * FROM `paymendetails` ORDER BY `P_ID` ";

		// Table   
		output = "<table border='1'><tr><th>Doctor Id</th><th>Patient Id</th><th>Prescription</th><th>Doctor Notes</th><th>Update</th><th>Remove</th></tr>"; 
			 
		
		DBConnection newconn = new DBConnection();
		ResultSet Select = newconn.GtResultSet(Query);
		
			
			while(Select.next())
			{
				Payment pay = new Payment();
				
				pay.setP_ID(Select.getString(1));
				pay.setPaient_id(Select.getInt(2));
				pay.setP_amount(Select.getDouble(3));
				pay.setP_method(Select.getString(4));
				pay.setP_Description(Select.getString(5));

				
				// Add into the html table 
				output += "<tr><td><input id=\'hidItemIDUpdate\' name=\'hidItemIDUpdate\' type=\'hidden\' value=\'" + pay.getP_ID() + "'>" 
							+ pay.getPaient_id() + "</td>";      
				output += "<td>" + pay.getP_amount() + "</td>";     
				output += "<td>" + pay.getP_method() + "</td>";
				output += "<td>" + pay.getP_Description() + "</td>"; 
				
				output +="<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>"       
						+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-docid='" + pay.getP_ID() + "'>" + "</td></tr>"; 
		
				
				
			}
			newconn.con.close();
			output += "</table>";  
			
			return output;
			
	}

	
	
	
	
	
	

	
	//Insert Into
	public String InsertIntoPay1ment(Payment pay) throws SQLException
	{
		DBConnection newconn = new DBConnection();
		String Query = "INSERT INTO `paymendetails` (`P_ID`,`Paient_id`,`P_amount`,`P_method`,`P_Description`) VALUES (?,?,?,?,?)";
		PreparedStatement Insert = newconn.GtPrepStatement(Query);
		
		Insert.setString(1, pay.getP_ID());
		Insert.setInt(2, pay.getPaient_id());
		Insert.setDouble(3, pay.getP_amount());
		Insert.setString(4, pay.getP_method());
		Insert.setString(5, pay.getP_Description());
		
		
		if(!Insert.execute())
		{
			newconn.con.close();
			return "Data Inserted Sucessfully";
		}
		else
		{
			newconn.con.close();
			return "Error Data Insert Unsucessful";
		}
		
	}
	
	
	//Delete
	public String DeleteDetails(String payid) throws SQLException
	{
		DBConnection newconn = new DBConnection();
		String query = "DELETE FROM `paymendetails` WHERE `P_ID` = ?";
		PreparedStatement prepstat = newconn.GtPrepStatement(query);
		prepstat.setString(1,payid);
		
		
		if(!prepstat.execute())
		{
			newconn.con.close();
			return  "Deleted Sucessfully";
		}
		else
		{
			newconn.con.close();
			return  "Delete Unsucessfull";
		}
	}
	
	
	
	
	
	
	
	
	//Update
	public String InsertIntoPayment(int Paient_id, Double amount, String method, String Description, String P_ID)throws SQLException
	{
		String output = "";
		try {
		DBConnection newconn = new DBConnection();
		String query = "UPDATE `paymendetails` SET `Paient_id`=?,`P_amount`=?,`P_method`=?,`P_Description`=? WHERE `paymendetails`.`P_ID` = ?; ";
	    PreparedStatement prepstat = newconn.GtPrepStatement(query);
	   
	    prepstat.setInt(1, Paient_id);
	    prepstat.setDouble(2, amount);
	    prepstat.setString(3, method);
	    prepstat.setString(4, Description);
	    
	    prepstat.setString(5, P_ID);
	    
	    prepstat.execute();
	    
	   String newAppo = SelectAll();    
		output = "{\"status\":\"success\", \"data\": \"" +        
				newAppo + "\"}"; 
		}
		catch (Exception e)   
		{    
			output =  "{\"status\":\"error\", \"data\": \"Error while inserting the Appointment.\"}";  
			System.err.println(e.getMessage());   
		} 
		
		return output;
		
		
		
	}
	
}

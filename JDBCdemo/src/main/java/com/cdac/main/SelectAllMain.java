package com.cdac.main;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectAllMain {
	public static void main(String[] args) {
		try {
			// Load the database drive
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Get Connection with the driver
			Connection con = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/cdacDB?useSSL=false","root","1234");  
			
			/* IMP** TCP/IP connection : connection oriented protocol it means ones 
			connection between application & DB established, the connection 
			is going to remain open	and DB is accessible continuously 
			so how busy your connection going to affect the DB performance 
			IMP** So, we Need to close the connection after the use */ 
			
			//Create Statement to execute query
			Statement stmt = con.createStatement();
			
			//Execute the query & Store result of query into ResultSet
			ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUCT");
			
			//Process data from the ResultSet
			if(rs.isBeforeFirst()) {
				while(rs.next()) {
					System.out.println(
							rs.getInt("pid") + ":" +
							rs.getString(2) + ":" +
							rs.getInt(3) + ":" +
							rs.getInt("qty"));
				}
			}
			else
				System.out.println("No Product available");
			
			// Close the DB connection
			con.close();  // TCP/IPs connection so need to close
		}
		catch(SQLException | ClassNotFoundException exc) {
			exc.printStackTrace();
		}
	}
}
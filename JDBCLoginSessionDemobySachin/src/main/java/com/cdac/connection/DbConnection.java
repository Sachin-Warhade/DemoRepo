package com.cdac.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static Connection getDatabseConnection() {
		
		try {
			 //load the Db driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// established the connection with driver
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/cdacDB","root","1234");
			
			return con;
			
		} catch (SQLException | ClassNotFoundException exc) {
			exc.printStackTrace();
			return null;
		}
	}
}

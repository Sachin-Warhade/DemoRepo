package com.sachin.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAllMainSachin {

	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/cdacDb?useSSL=false", "root", "1234");

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("Select * from product");

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					System.out.println(rs.getInt("pid") + ":" + rs.getString(2) + ":" + rs.getInt(3)+":"+rs.getInt(4));
				}
			}
			else {
				System.out.println("Product Not Found");
			}
			
			con.close();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		/*
		 * try {
		 * 
		 * Class.forName("com.mysql.cj.jdbc.Driver");
		 * 
		 * Connection con = DriverManager.getConnection(
		 * "jdbc:mysql://localhost:3306/cdacDB?useSSL=false","root", "1234");
		 * //"jdbc:mysql://localhost:3306/cdacDB?useSSL=false","root","1234" Statement
		 * stmt = con.createStatement();
		 * 
		 * ResultSet rs = stmt.executeQuery("Select * from product");
		 * 
		 * if (rs.isBeforeFirst()) { while (rs.next()) { System.out.println(rs.getInt(1)
		 * + ":" + rs.getString(2) + ":" + rs.getInt(3) + ":" + rs.getInt(4)); } } else
		 * { System.out.println("No product Available"); }
		 * 
		 * con.close();
		 * 
		 * } catch (SQLException | ClassNotFoundException e) { e.printStackTrace(); }
		 */

	}

}

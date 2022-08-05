package com.cdac.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cdac.connection.DbConnection;
import com.cdac.dao.UserDao;
import com.cdca.pojo.User;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean checkUserCredentials(User user) {

		try (Connection con = DbConnection.getDatabseConnection()) {

			PreparedStatement pst = con
					.prepareStatement("SELECT * FROM userdata WHERE username = ? and password = ?");

			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			
		ResultSet rs = pst.executeQuery();
		
		if(rs.isBeforeFirst())
			return true;
		else
			return false;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addNewUser(User user) {

		try(Connection con = DbConnection.getDatabseConnection()) {
			
			PreparedStatement pst = 
					con.prepareStatement("INSERT INTO userdata VALUES(?,?)");
			
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			
			int count = pst.executeUpdate();
			
			if(count>0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}

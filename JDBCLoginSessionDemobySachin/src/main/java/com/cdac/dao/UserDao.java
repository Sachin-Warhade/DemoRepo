package com.cdac.dao;

import com.cdca.pojo.User;

public interface UserDao {

	boolean checkUserCredentials(User user);
	boolean addNewUser(User user);
}

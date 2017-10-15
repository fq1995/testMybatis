package com.fu.dao;

import com.fu.po.User;

public interface UserDao {
	
	//根据ID查询用户信息
	public User findUserById(int id) throws Exception;
	
	//添加用户信息
	public void insertUser(User user) throws Exception;
		
	//删除用户信息	
	public void deleteUser(int id) throws Exception;
}

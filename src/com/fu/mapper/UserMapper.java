package com.fu.mapper;

import java.util.List;

import com.fu.po.User;
import com.fu.po.UserCustom;
import com.fu.po.UserQueryVo;

public interface UserMapper {
	// 根据ID查询用户信息，使用resultMap输出
	public User findUserByIdResultMap (int id) throws Exception;

	//用户信息综合查询
	public List<UserCustom> findUserList(UserQueryVo userQueryVo);
	
	//用户信息综合查询
	public int findUserCount(UserQueryVo userQueryVo);
	
	// 根据ID查询用户信息
	public User findUserById (int id) throws Exception;

	// 添加用户信息
	public void insertUser(User user) throws Exception;

	// 删除用户信息
	public void deleteUser(int id) throws Exception;
	
	//更新用户
	public void updateUser(User user) throws Exception;
}

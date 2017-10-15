package com.fu.mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.fu.dao.UserDao;
import com.fu.dao.impl.UserDaoImpl;
import com.fu.po.User;

public class UserDaoImplTest {
	private SqlSessionFactory sqlSessionFactory = null;
	@Before
	public void setUp() throws Exception {
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		//得到配置文件流
		Reader reader = Resources.getResourceAsReader(resource);
		//创建回话工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	
	@Test
	public void testFindUserById() throws Exception {
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = userDao.findUserById(1);
		System.out.println(user);
	}

	@Test
	public void testInsertUser() {
		
	}

	@Test
	public void testDeleteUser() {
	}

}

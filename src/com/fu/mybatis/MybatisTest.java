package com.fu.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.fu.po.User;

public class MybatisTest {

	@Test
	public void findUserById(){
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		Reader reader = null;
		SqlSession sqlSession = null;
		try {
			//得到配置文件流
			reader = Resources.getResourceAsReader(resource);
			//创建回话工厂
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			//通过工厂得到SqlSession
			sqlSession = sqlSessionFactory.openSession();
			User user = sqlSession.selectOne("test.findUserById", 1);
			System.out.println(user.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//释放资源
			sqlSession.close();
		}
		
	}
	
	
	@Test
	public void findUserByName(){
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		Reader reader = null;
		SqlSession sqlSession = null;
		try {
			//得到配置文件流
			reader = Resources.getResourceAsReader(resource);
			//创建回话工厂
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			//通过工厂得到SqlSession
			sqlSession = sqlSessionFactory.openSession();
			List<User> user = sqlSession.selectList("test.findUserbyName", "王");
			System.out.println(user.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//释放资源
			sqlSession.close();
		}
		
	}
	
	
	@Test
	public void insertUser(){
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		Reader reader = null;
		SqlSession sqlSession = null;
		try {
			//得到配置文件流
			reader = Resources.getResourceAsReader(resource);
			//创建回话工厂
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			//通过工厂得到SqlSession
			sqlSession = sqlSessionFactory.openSession(true);
			User user = new User();
			user.setUsername("刘四");
			user.setAddress("上海");
			user.setBirthday(new Date());
			user.setSex("男");
			sqlSession.insert("test.insertUser", user);
			System.out.println(user.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//释放资源
			sqlSession.close();
		}
		
	}
	
	@Test
	public void deleteUser(){
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		Reader reader = null;
		SqlSession sqlSession = null;
		try {
			//得到配置文件流
			reader = Resources.getResourceAsReader(resource);
			//创建回话工厂
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			//通过工厂得到SqlSession
			sqlSession = sqlSessionFactory.openSession(true);
			int num = sqlSession.delete("test.deleteUser", 6);
			System.out.println(num);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//释放资源
			sqlSession.close();
		}
		
	}
	
	@Test
	public void updateUser(){
		//mybatis配置文件
		String resource = "SqlMapConfig.xml";
		Reader reader = null;
		SqlSession sqlSession = null;
		try {
			//得到配置文件流
			reader = Resources.getResourceAsReader(resource);
			//创建回话工厂
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			//通过工厂得到SqlSession
			sqlSession = sqlSessionFactory.openSession(true);
			User user = new User();
			user.setId(3);
			user.setUsername("王小二");
			user.setAddress("重庆");
			user.setBirthday(new Date());
			user.setSex("男");
			int num = sqlSession.update("test.updateUser", user);
			System.out.println(num);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//释放资源
			sqlSession.close();
		}
		
	}
	
}

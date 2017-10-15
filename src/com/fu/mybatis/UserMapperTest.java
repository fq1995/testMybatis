package com.fu.mybatis;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.fu.mapper.UserMapper;
import com.fu.po.User;
import com.fu.po.UserCustom;
import com.fu.po.UserQueryVo;

public class UserMapperTest {
	private SqlSessionFactory sqlSessionFactory = null;

	@Before
	public void setUp() throws Exception {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		Reader reader = Resources.getResourceAsReader(resource);
		// 创建回话工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

	}

	@Test
	public void testFindUserById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.findUserById(1);
		System.out.println(user);
		sqlSession.close();
	}

	@Test
	public void testInsertUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		User user = new User();
		user.setUsername("月华");
		user.setBirthday(new Date());
		user.setAddress("澳门");
		user.setSex("女");
		mapper.insertUser(user);
		sqlSession.close();
	}

	@Test
	public void testDeleteUser() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		try {
			mapper.deleteUser(6);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sqlSession.close();
	}

	@Test
	public void testFidUserList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom user = new UserCustom();
		user.setUsername("四");
		// user.setAddress("上海");

		// 传入多个id
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(4);
		ids.add(5);
		ids.add(6);
		userQueryVo.setIds(ids);
		userQueryVo.setUserCustom(user);
		mapper.findUserList(userQueryVo);
		sqlSession.close();
	}

	@Test
	public void testFidUserCount() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);

		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom user = new UserCustom();
		user.setUsername("四");
		user.setAddress("上海");
		userQueryVo.setUserCustom(user);
		System.out.println(mapper.findUserCount(userQueryVo));
		sqlSession.close();
	}

	@Test
	public void findUserByIdResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.findUserByIdResultMap(1);
		System.out.println(user);
		sqlSession.close();
	}

	// 一级缓存
	@Test
	public void testCache1() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.findUserById(1);
		System.out.println(user);

		user.setSex("男");
		mapper.updateUser(user);

		User user2 = mapper.findUserById(1);
		System.out.println(user2);

		sqlSession.close();
	}

	// 二级缓存
	@Test
	public void testCache2() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
		SqlSession sqlSession3 = sqlSessionFactory.openSession(true);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.findUserById(1);
		System.out.println(user);
		//讲sqlSession中的数据写入二级缓存
		sqlSession.close();
		
		UserMapper mapper3 = sqlSession3.getMapper(UserMapper.class);
		User user3 = mapper3.findUserById(1);
		user3.setSex("女");
		mapper3.updateUser(user3);
		
		
		UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
		User user2 = mapper2.findUserById(1);
		System.out.println(user2);

		sqlSession2.close();
	}

}

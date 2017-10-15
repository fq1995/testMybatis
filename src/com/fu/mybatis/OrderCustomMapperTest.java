package com.fu.mybatis;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.fu.mapper.OrderCustomMapper;
import com.fu.po.OrderCustom;
import com.fu.po.Orders;
import com.fu.po.User;

public class OrderCustomMapperTest {
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
	public void testFindOrderdUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		OrderCustomMapper mapper = sqlSession.getMapper(OrderCustomMapper.class);
		List<OrderCustom> list = mapper.findOrderdUser();
		for (OrderCustom orderCustom : list) {
			System.out.println(orderCustom.toString());
		}
		sqlSession.close();
	}

	
	@Test
	public void testFindOrderdUserResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		OrderCustomMapper mapper = sqlSession.getMapper(OrderCustomMapper.class);
		List<Orders> list = mapper.findOrderdUserResultMap();
		for (Orders order : list) {
			System.out.println(order.toString());
		}
		sqlSession.close();
	}
	
	
	@Test
	public void testfindOrderdsAndOrderDetailResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		OrderCustomMapper mapper = sqlSession.getMapper(OrderCustomMapper.class);
		List<Orders> list = mapper.findOrderdsAndOrderDetailResultMap();
		System.out.println(list);
		sqlSession.close();
	}
	
	@Test
	public void testfindUserAndItemsResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		OrderCustomMapper mapper = sqlSession.getMapper(OrderCustomMapper.class);
		List<User> list = mapper.findUserAndItemsResultMap();
		System.out.println(list);
		sqlSession.close();
	}
	
	@Test
	public void testfindOrdersUserLazyLoading() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		OrderCustomMapper mapper = sqlSession.getMapper(OrderCustomMapper.class);
		List<Orders> list = mapper.findOrdersUserLazyLoading();
		for (Orders orders : list) {
			User user = orders.getUser();
			System.out.println(user);
		}
		sqlSession.close();
	}
	
	
}

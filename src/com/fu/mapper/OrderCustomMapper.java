package com.fu.mapper;

import java.util.List;

import com.fu.po.OrderCustom;
import com.fu.po.Orders;
import com.fu.po.User;

public interface OrderCustomMapper {
	
	// 查询订单关联用户信息 
	public List<OrderCustom> findOrderdUser() throws Exception; 

	//查询订单关联用户信息 使用resultMap
	public List<Orders> findOrderdUserResultMap() throws Exception;

	//查询订单关联用户和订单明细信息 使用resultMap
	public List<Orders> findOrderdsAndOrderDetailResultMap() throws Exception;
	
	//查询用户及商品信息 使用resultMap
	public List<User> findUserAndItemsResultMap() throws Exception;
		
	//查询订单关联用户， 用户信息延迟加载 
	public List<Orders> findOrdersUserLazyLoading() throws Exception;
}

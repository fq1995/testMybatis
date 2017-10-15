package com.fu.po;

import java.util.List;

/**
 * 包装类
 * @author fu
 *
 */
public class UserQueryVo {
	
	private UserCustom userCustom;
	List<Integer> ids;
	
	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
	
	
}

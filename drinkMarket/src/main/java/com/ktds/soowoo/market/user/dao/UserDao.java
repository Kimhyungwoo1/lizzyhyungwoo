package com.ktds.soowoo.market.user.dao;

import com.ktds.soowoo.market.user.vo.UserVO;

public interface UserDao {

	public int insertUser(UserVO userVO);
	
	public UserVO selectUser(UserVO userVO);
	
	public int updatePoint(String userId, int point);
	
}

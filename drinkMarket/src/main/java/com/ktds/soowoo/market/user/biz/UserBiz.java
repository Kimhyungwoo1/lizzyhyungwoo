package com.ktds.soowoo.market.user.biz;

import com.ktds.soowoo.market.user.vo.UserVO;

public interface UserBiz {

	public boolean addUser(UserVO userVO);
	
	public UserVO signInUser(UserVO userVO);
	
	public boolean pointUp(String userId, int point);
	
}

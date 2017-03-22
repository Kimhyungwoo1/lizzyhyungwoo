package com.ktds.soowoo.market.user.service;

import com.ktds.soowoo.market.user.biz.UserBiz;
import com.ktds.soowoo.market.user.biz.UserBizImpl;
import com.ktds.soowoo.market.user.vo.UserVO;

public class UserServiceImpl implements UserService{

	private UserBiz userBiz;
	
	public UserServiceImpl() {
		userBiz = new UserBizImpl();
	}
	
	@Override
	public boolean addUser(UserVO userVO) {
		return userBiz.addUser(userVO);
	}

	@Override
	public UserVO signInUser(UserVO userVO) {
		return userBiz.signInUser(userVO);
	}

	@Override
	public boolean pointUp(String userId, int point) {
		return userBiz.pointUp(userId, point);
	}

}

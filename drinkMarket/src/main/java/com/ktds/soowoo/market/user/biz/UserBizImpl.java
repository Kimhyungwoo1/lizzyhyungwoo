package com.ktds.soowoo.market.user.biz;

import com.ktds.soowoo.market.user.dao.UserDao;
import com.ktds.soowoo.market.user.dao.UserDaoImpl;
import com.ktds.soowoo.market.user.vo.UserVO;

public class UserBizImpl implements UserBiz{

	private UserDao userDao;
	
	public UserBizImpl() {
		userDao = new UserDaoImpl();
	}
	
	@Override
	public boolean addUser(UserVO userVO) {
		return userDao.insertUser(userVO) > 0;
	}

	@Override
	public UserVO signInUser(UserVO userVO) {
		return userDao.selectUser(userVO);
	}

	@Override
	public boolean pointUp(String userId, int point) {
		return userDao.updatePoint(userId, point) > 0;
	}

	
	
}

package com.ktds.soowoo.market.user.service;

import com.ktds.soowoo.market.user.vo.UserVO;

public interface UserService {

	public boolean addUser(UserVO userVO);

	public UserVO signInUser(UserVO userVO);

	public boolean pointUp(String userId, int point);

}

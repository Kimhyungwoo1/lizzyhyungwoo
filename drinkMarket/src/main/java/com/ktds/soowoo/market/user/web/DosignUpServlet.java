package com.ktds.soowoo.market.user.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.soowoo.market.user.service.UserService;
import com.ktds.soowoo.market.user.service.UserServiceImpl;
import com.ktds.soowoo.market.user.vo.UserVO;

public class DosignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;
	
	public DosignUpServlet() {
		userService = new UserServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/user/signUp.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		
		UserVO userVO = new UserVO();
		userVO.setUserId(userId);
		userVO.setUserName(userName);
		userVO.setUserPassword(userPassword);
		
		boolean userSignUp = userService.addUser(userVO);
		
		if( userSignUp ){
			response.sendRedirect("/drinkMarket/drinkList");
		}
		else {
			response.sendRedirect("/drinkMarket/user/signUp");
		}
		
	}

}

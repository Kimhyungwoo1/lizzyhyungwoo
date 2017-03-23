package com.ktds.soowoo.market.user.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.soowoo.market.drink.service.DrinkService;
import com.ktds.soowoo.market.drink.service.DrinkServiceImpl;
import com.ktds.soowoo.market.drink.vo.DrinkVO;
import com.ktds.soowoo.market.user.service.UserService;
import com.ktds.soowoo.market.user.service.UserServiceImpl;

public class DoUpdatePointServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DrinkService drinkService;
	private UserService userService;
       
    public DoUpdatePointServlet() {
    	drinkService = new DrinkServiceImpl();
    	userService = new UserServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String drinkId = request.getParameter("drinkId");
		
		DrinkVO drinkVO = drinkService.getOneDrink(drinkId);
		drinkVO.setQuantity(drinkVO.getQuantity()-1);
		
		boolean isChange = drinkService.modifyOneDrink(drinkVO);
		
		int point = (int)(drinkVO.getPrice() * drinkVO.getPointPct());
		
		boolean isUpdate = userService.pointUp(userId, point);
		boolean isSuccess = isChange == true && isUpdate == true ? true : false;
		
		StringBuffer json = new StringBuffer(); 
		json.append(" { ");
		json.append(" \"status\" : \"success\", "); 
		json.append(" \"success\" : " + isSuccess);
		json.append(" } ");
		
		PrintWriter writer = response.getWriter();
		writer.write(json.toString());
		writer.flush();
		writer.close();
	}

}

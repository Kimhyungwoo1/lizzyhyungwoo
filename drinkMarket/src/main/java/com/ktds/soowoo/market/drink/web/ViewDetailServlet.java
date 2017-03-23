package com.ktds.soowoo.market.drink.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.soowoo.market.drink.service.DrinkService;
import com.ktds.soowoo.market.drink.service.DrinkServiceImpl;
import com.ktds.soowoo.market.drink.vo.DrinkVO;

public class ViewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DrinkService drinkService;
       
    public ViewDetailServlet() {
    	drinkService = new DrinkServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String drinkId = request.getParameter("drinkId");
		DrinkVO drinkVO = drinkService.getOneDrink(drinkId);
		
		request.setAttribute("drink", drinkVO);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/drink/detail.jsp");
		dispatcher.forward(request, response);
	}

}

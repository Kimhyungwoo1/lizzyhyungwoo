package com.ktds.soowoo.market.drink.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.soowoo.market.common.web.download.DownloadUtil;
import com.ktds.soowoo.market.drink.service.DrinkService;
import com.ktds.soowoo.market.drink.service.DrinkServiceImpl;
import com.ktds.soowoo.market.drink.vo.DrinkVO;

public class ViewPostImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DrinkService drinkService;
       
    public ViewPostImageServlet() {
    	drinkService = new DrinkServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String drinkId = request.getParameter("drinkId");
		
		DrinkVO drinkVO = drinkService.getOneDrink(drinkId);
		
		String postPath = "D:\\DrinkUploadFiles\\post\\";
		postPath += drinkVO.getTypeVO().getTypeName() + File.separator;
		postPath += drinkVO.getCountryVO().getCountryName();

		DownloadUtil downloadUtil = DownloadUtil.getInstance(postPath);
		downloadUtil.download(request, response, drinkVO.getImage(), drinkVO.getImage());
	}

}

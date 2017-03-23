package com.ktds.soowoo.market.country.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.soowoo.market.country.service.CountryService;
import com.ktds.soowoo.market.country.service.CountryServiceImpl;
import com.ktds.soowoo.market.country.vo.CountryVO;

public class ViewCountryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CountryService countryService;
	
	public ViewCountryListServlet() {
		countryService = new CountryServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<CountryVO> countryList = countryService.allListCountry();
		
		request.setAttribute("countryList", countryList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/drink/countryList.jsp");
		dispatcher.forward(request, response);
		
	}

}

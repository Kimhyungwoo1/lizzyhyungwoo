package com.ktds.soowoo.market.drink.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.soowoo.market.country.service.CountryService;
import com.ktds.soowoo.market.country.service.CountryServiceImpl;
import com.ktds.soowoo.market.country.vo.CountryVO;
import com.ktds.soowoo.market.drink.service.DrinkService;
import com.ktds.soowoo.market.drink.service.DrinkServiceImpl;
import com.ktds.soowoo.market.drink.vo.DrinkSearchVO;
import com.ktds.soowoo.market.drink.vo.DrinkVO;
import com.ktds.soowoo.market.type.service.TypeService;
import com.ktds.soowoo.market.type.service.TypeServiceImpl;
import com.ktds.soowoo.market.type.vo.TypeVO;
import com.ktds.soowoo.market.user.vo.UserVO;
import com.meister.commom.pager.ClassicPageExplorer;
import com.meister.commom.pager.PageExplorer;

public class ViewDrinkListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DrinkService drinkService;
	private CountryService countryService;
	private TypeService typeService;

	public ViewDrinkListServlet() {
		drinkService = new DrinkServiceImpl();
		countryService = new CountryServiceImpl();
		typeService = new TypeServiceImpl();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pageNo = request.getParameter("pageNo");
		DrinkSearchVO drinkSearchVO = new DrinkSearchVO();
		drinkSearchVO.getPager().setPageNumber(pageNo);

		List<DrinkVO> drinkList = drinkService.getAllDrinks(drinkSearchVO);
		List<CountryVO> countryList = countryService.allListCountry();
		List<TypeVO> typeList = typeService.AllTypeList();

		PageExplorer pager = new ClassicPageExplorer(drinkSearchVO.getPager());
		
		HttpSession session = request.getSession(true);
		UserVO userVO = (UserVO)session.getAttribute("_USER_");
		boolean isLogin = userVO != null ? true : false;
		
		request.setAttribute("isLogin", isLogin);
		request.setAttribute("drinkList", drinkList);
		request.setAttribute("countryList", countryList);
		request.setAttribute("typeList", typeList);
		request.setAttribute("drinkCount", drinkSearchVO.getPager().getTotalArticleCount());
		request.setAttribute("pager", pager.getPagingList("pageNo", "[@]", "prev", "next", "searchForm"));

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/mainList.jsp");
		dispatcher.forward(request, response);
	}

}

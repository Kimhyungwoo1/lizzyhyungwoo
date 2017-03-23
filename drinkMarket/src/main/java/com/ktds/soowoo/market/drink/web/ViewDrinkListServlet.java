package com.ktds.soowoo.market.drink.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.soowoo.market.common.web.pager.ClassicPageExplorer;
import com.ktds.soowoo.market.common.web.pager.PageExplorer;
import com.ktds.soowoo.market.drink.service.DrinkService;
import com.ktds.soowoo.market.drink.service.DrinkServiceImpl;
import com.ktds.soowoo.market.drink.vo.DrinkSearchVO;
import com.ktds.soowoo.market.drink.vo.DrinkVO;
import com.ktds.soowoo.market.user.vo.UserVO;

public class ViewDrinkListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DrinkService drinkService;

	public ViewDrinkListServlet() {
		drinkService = new DrinkServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pageNo = request.getParameter("pageNo");
		DrinkSearchVO drinkSearchVO = new DrinkSearchVO();
		drinkSearchVO.getPager().setPageNumber(pageNo);

		List<DrinkVO> drinkList = drinkService.getAllDrinks(drinkSearchVO);

		PageExplorer pager = new ClassicPageExplorer(drinkSearchVO.getPager());
		
		HttpSession session = request.getSession(true);
		UserVO userVO = (UserVO)session.getAttribute("_USER_");
		boolean isLogin = userVO != null ? true : false;
		
		request.setAttribute("isLogin", isLogin);
		request.setAttribute("drinkList", drinkList);
		request.setAttribute("drinkCount", drinkSearchVO.getPager().getTotalArticleCount());
		request.setAttribute("pager", pager.getPagingList("pageNo", "[@]", "prev", "next", "searchForm"));

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/mainList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}

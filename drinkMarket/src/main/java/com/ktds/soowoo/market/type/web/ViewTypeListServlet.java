package com.ktds.soowoo.market.type.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.soowoo.market.type.service.TypeService;
import com.ktds.soowoo.market.type.service.TypeServiceImpl;
import com.ktds.soowoo.market.type.vo.TypeVO;

public class ViewTypeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TypeService typeService;
	
	public ViewTypeListServlet() {
		typeService = new TypeServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<TypeVO> typeList = typeService.AllTypeList();
		
		request.setAttribute("typeList", typeList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/drink/type.jsp");
		dispatcher.forward(request, response);
		
	}

}

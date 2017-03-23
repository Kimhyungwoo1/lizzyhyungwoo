<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/template/common_header.jsp"/>
<link rel="stylesheet" type="text/css" href="/drinkMarket/static/css/list_layout.css"/>
<link rel="stylesheet" type="text/css" href="/drinkMarket/static/css/detail_layout.css"/>

	<div class="detail" data-price="${drink.price}">
		<h1>${drink.drinkName}</h1>
		<hr/>
		<img src="/drinkMarket/drink/post?drinkId=${drink.drinkId}" style="margin-left: auto; margin-right: auto; display: block;"/><br/><!-- style="max-width: 242px; height: auto;" -->
		<div class="detail_content" style="display: inline-block; width:709px;">
			<table id ="table">
				<tr>
					<th>가격</th>
					<td>${drink.price}</td>
				</tr>
				<tr>
					<th>종류</th>
					<td>${drink.typeVO.typeName}</td>
				</tr>
				<tr>
					<th>제조사</th>
					<td>${drink.companyVO.companyName}</td>
				</tr>
				<tr>
					<th>원산지</th>
					<td>${drink.countryVO.countryName}</td>
				</tr>
			</table>
			<br/>
			<table>
				<tr>
					<th>상세 설명</th>
				</tr>
				<tr>
					<td style="text-align:center">${drink.detail}</td>
				</tr>
			</table>
		</div>
		<div class="buyDiv">
			<img id="cart" src="/drinkMarket/static/img/shopping-cart-349544_960_720.png" data-user="${sessionScope._USER_.userId}" style="margin-left: auto; margin-right: auto; display: block; width:70px; height:70px"/>
		</div>
		<hr/>
		<div class="controls">
			<a href="/drinkMarket/drinkList">목록으로 돌아가기</a>
		</div>
	</div><!-- 
 --><div class="login">
		<c:if test="${empty sessionScope._USER_}">
			<jsp:include page="/WEB-INF/view/user/signIn.jsp" />
		</c:if>
		<c:if test="${not empty sessionScope._USER_}">
			${sessionScope._USER_.userName}님, 환영쓰~
			<input type="button" value="logOut" onclick="location.href='/drinkMarket/user/logout'" />
		</c:if>
	</div>

<jsp:include page="/WEB-INF/template/common_footer.jsp"/>
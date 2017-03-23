<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/WEB-INF/template/common_header.jsp"/>
<link rel="stylesheet" type="text/css" href="/boardTest/css/list_layout.css"/>

	<div class="grid"> 
		<h3>술이 이만큼이나 있어요^^! [${drinkCount}개]</h3>
		<table>
			<tr>
				<c:forEach items="${drinkList}" var="drink" varStatus="index"> 
					<td>
						<div>
							<a href="/drinkMarket/drink/detail?drinkId=${drink.drinkId}">
								<img src="/drinkList/drink/post?drinkId=${drink.drinkId}" width="223px" height="236px"/><br/>
							</a>
							<h3>${drink.drinkName}</h3>
							<h4>${drink.price}</h4>
						</div>
					</td>
					<c:if test="${(index.index + 1) % 3 == 0}">
						</tr>
						<tr>
					</c:if>
				</c:forEach>
			</tr>
		</table>
		<div class="bottomMenu"><!--  
		 --><div class="pagingLink">
				<form method="post" id="searchForm">
					${pager}
				</form>
			</div><!--  
	--></div><!--  	
 --></div><!-- 
	--><div class="login">
		<c:if test="${empty sessionScope._USER_}">
			<jsp:include page="/WEB-INF/view/user/signIn.jsp"/>
		</c:if>
		<c:if test="${not empty sessionScope._USER_}">
			${sessionScope._USER_.userName}님, 환영쓰~
			<input type="button" id="logOut" value="logOut" />
		</c:if>
	</div>

<jsp:include page="/WEB-INF/template/common_footer.jsp"/>
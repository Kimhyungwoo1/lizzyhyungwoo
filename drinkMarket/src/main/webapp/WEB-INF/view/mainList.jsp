<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/WEB-INF/template/common_header.jsp"/>
<link rel="stylesheet" type="text/css" href="/boardTest/css/list_layout.css"/>

	<div class="grid"> <!-- content 이하에서는 id말고 class 사용 -->
		<p>술이 이만큼이나 있어요^^! [${drinkCount}개]</p>
		<table>
			<tr>
				<c:forEach items="${drinkList}" var="drink" varStatus="index"> <!-- index를 통해 몇 번째 반복인지 알 수 있다 -->
					<td>
						${index.index}<br/>
						<div>
							<a href="/drinkMarket/drink/detail?drinkId=${drink.drinkId}">
							<!-- 보안 강화 : 사용자가 임의로 url에 접근할 수 없도록 (유추 X) 파라미터를 두개 넣음 -->
								<img src="/drinkList/drink/post?drinkId=${drink.drinkId}" width="200px" height="200px"/><br/>
							</a>
							${drink.drinkName}<br/>
							${drink.price}
						</div>
					</td>
					<c:if test="${(index.index + 1) % 5 == 0}">
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
		<%-- <c:if test="${empty sessionScope._USER_}">
		<!-- 로그인 안 됐을 경우(null=empty) : Session정보를 EL에서 가져옴 (jsp 내장 객체) -->
			<jsp:include page="/WEB-INF/view/user/signIn.jsp"/> <!-- signIn.jsp를 그대로 보여주기 -->
		</c:if>
		<!-- 로그인을 했을 경우 -->
		<c:if test="${not empty sessionScope._USER_}">
			${sessionScope._USER_.userName}님, 환영쓰~
		</c:if> --%>
	</div>

<jsp:include page="/WEB-INF/template/common_footer.jsp"/>
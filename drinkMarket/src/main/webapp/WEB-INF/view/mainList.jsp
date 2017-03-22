<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main Page - Drink Market</title>
<script type="text/javascript" src="/drinkMarket/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>

	<p>술 ${drinkCount}</p>
	<table>
		<tr>
			<th>번호</th>
			<th>아티스트 명</th>
			<th>데뷔 일자</th>
		</tr>
		<c:forEach items="${artistList}" var="artist">
			<tr>
				<td>
					<fmt:parseNumber>
						${fn:split(artist.artistId, '-')[2]}
					</fmt:parseNumber>
				</td>
				<td class="member" data-name="${artist.artistId}">
					<a href="/melon/album/list?artistId=${artist.artistId}">${artist.member}</a>
				</td>
				<td>${artist.debutDate}</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<form id="searchForm">
			${pager}
		</form>
	</div>

</body>
</html>
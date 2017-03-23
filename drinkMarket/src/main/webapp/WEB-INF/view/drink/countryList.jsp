<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>countryList</title>
</head>
<body>
	<table>
		<tr>
			<c:forEach items="${countryList}" var="list">
				<td>${list.countryName}</td>
			</c:forEach>
		</tr>
	</table>
</body>
</html>
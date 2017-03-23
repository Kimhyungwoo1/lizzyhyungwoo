<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>typeList</title>
</head>
<body>
	<table>
		<tr>
			<c:forEach items="${typeList}" var="list">
				<td>${list.typeName}</td>
			</c:forEach>
		</tr>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/drinkMarket/static/css/common_layout.css"/>
<script type="text/javascript" src="/drinkMarket/static/js/jquery-3.1.1.min.js"></script>
</head>
<body>
	<div id="wrapper"> <!-- wrapper = content를 감싼다 -->
		<div id="nav"> <!-- nav = navigation bar -->
			<c:choose>
				<c:when test="!${isLogin}">
					<a href="/boardTest/user/signIn">Login</a><a href="/boardTest/user/signUp">Join</a>
				</c:when>
				<c:otherwise>
					<a href="/boardTest/user/doSignOut">Logout</a>
				</c:otherwise>
			</c:choose>
			
		</div>
	<div id="content">
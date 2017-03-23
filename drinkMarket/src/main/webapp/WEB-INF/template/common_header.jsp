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
<script type="text/javascript">
	$().ready(function() {
		$("#cart").click(function(){
			$.post("/drinkMarket/user/updatePoint", {
				"userId" : $("#cart").data("user"),
				"drinkId" : "${param.drinkId}"
			},function(response){
				var jsonObj = JSON.parse(response);
				console.log(jsonObj);
				
				if (jsonObj.success) {
					alert("구매 성공!");
				}
				else 
					alert("구매 실패...");
			});
		});
	});
</script>
</head>
<body>
	<div id="wrapper"> 
		<div id="nav"> 
			<a href="/drinkMarket/type" style="margin-right:10px; margin-left:10px; text-decoration:none">종류별</a>
			<a href="/drinkMarket/country" style="margin-right:10px; margin-left:10px; text-decoration:none">나라별</a>
		</div>
	<div id="content">
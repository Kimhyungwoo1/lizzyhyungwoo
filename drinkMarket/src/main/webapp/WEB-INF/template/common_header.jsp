<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/drinkMarket/static/css/common_layout.css" />
<link rel="stylesheet" type="text/css" href="/drinkMarket/static/css/123.css" />
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

		$(".topnav").hover(function() {                    //마우스를 topnav에 오버시
			$(this).parent().find(".subnav").slideDown('normal').show();                   //subnav가 내려옴.
			
			$(this).parent().hover(function() {  
			}, function(){  
				$(this).parent().find(".subnav").slideUp('slow');                 //subnav에서 마우스 벗어났을 시 원위치시킴  
			});  
		});
		
	});  

</script>
</head>
<body>
<div id=wrapper>
	<div class="gnb">
		<ul>
			<li>
				<a>나라별</a>
				<ul>
					<c:forEach items="countryList" var="country">
						<li><a href="drinkMarket/country/list?countryId=${country.countryId}">${country.countryName}</a></li>
					</c:forEach>
				</ul>
			</li>

			<li>
				<a>종류별</a>
				<ul>
					<c:forEach items="typeList" var="type">
						<li><a href="drinkMarket/type/list?typeId=${type.typeId}">${type.typeName}</a></li>
					</c:forEach>
				</ul>
			</li>
		</ul>

	</div>



	<!-- <a href="/drinkMarket/type" style="margin-right:10px; margin-left:10px; text-decoration:none">종류별</a>
			<a id=country href="/drinkMarket/country" style="margin-right:10px; margin-left:10px; text-decoration:none">나라별</a>
		 -->

		<div id="content">

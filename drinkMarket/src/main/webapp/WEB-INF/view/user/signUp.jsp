<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/drinkMarket/static/css/signUp.css"/>
<title>SignUp</title>
<script type="text/javascript" src="/drinkMarket/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$().ready(function () {
		$("#signUp").find("input[type=button]").click(function() {
			$("#signUP").attr({
				"method" : "post",
				"action" : "/drinkMarket/user/signUP"
			});
		});
	});
</script>
</head>
<body>
	<div id=all>
		<form id=signUP>
			<input type="text" name="userId" placeholder="아이디를 입력하세요." /><br/>
			<input type="text" name="userPassword" placeholder="페스워드를 입력하세요." /><br/>
			<input type="text" name="userName" placeholder="이름를 입력하세요." /><br/>
			<input type="button" value="확인" />
		</form>
	</div>
	
</body>
</html>
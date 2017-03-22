<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>SignIn</title>
<link rel="stylesheet" type="text/css" href="/drinkMarket/static/css/signIn.css"/>
<script type="text/javascript" src="/drinkMarket/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$().ready(function () {
		$("#button").click(function() {
			$("#signIn").attr({
				"method" : "post",
				"action" : "/drinkMarket/user/signin"
			});
			$("#signIn").submit();
		});
		$("#signUp").click(function() {
			window.open("/drinkMarket/user/signUp")
		});
	});
</script>
</head>
<body>
<div id=asd>
	<div id=sign >
	<form id=signIn>
		<input type="text" name="userId" placeholder="���̵� �Է��ϼ���." /><br/>
		<input type="password" name="userPassword" placeholder="�佺���带  �Է��ϼ���." /><br/>
		<input type="button" id="button" value="signIn" />
		<input type="button" id="signUp" value="signUp" />
	</form>
		
	</div>
</div>
</body>
</html>
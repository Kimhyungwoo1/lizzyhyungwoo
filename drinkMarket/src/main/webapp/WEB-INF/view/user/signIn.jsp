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
		<div id=userId>
			<input type="text" name="userId" placeholder="아이디를 입력하세요." /><br/>
		</div>
		<div id=button>
			<input type="button" value="signIn" />
		</div>
		<div>
			<div id=password>
				<input type="password" name="userPassword" placeholder="페스워드를  입력하세요." /><br/>
			</div>
			<div id=signUp>
				<input type="button" id="signUp" value="signUp" />
			</div>
		</div>
	</form>
		
	</div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>SignIn</title>
<script type="text/javascript" src="/drinkMarket/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$().ready(function () {
		$("#signIn").find("input[type=button]").click(function() {
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

	<form id=signIn>
		<input type="text" name="userId" placeholder="아이디를 입력하세요." /><br/>
		<input type="password" name="userPassword" placeholder="페스워드를  입력하세요." /><br/>
		<input type="button" value="signIn" />
	</form>
		<input type="button" id="signUp" value="signUp" />

</body>
</html>
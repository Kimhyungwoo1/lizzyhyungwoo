<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
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
	
	<form id=signUP>
		<input type="text" name="userId" placeholder="���̵� �Է��ϼ���." />
		<input type="text" name="userPassword" placeholder="�佺���带 �Է��ϼ���." />
		<input type="text" name="userName" placeholder="�̸��� �Է��ϼ���." />
		<input type="button" value="Ȯ��" />
	</form>
	
</body>
</html>
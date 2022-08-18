<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
		<form method="post" action="LoginController" id="loginForm">
			<fieldset>
				<legend>로그인</legend>	
				<table border="1">
					<tr>
						<td>ID</td>
						<td><input type="text" name="id" id="id"></td>
					</tr>
					<tr>
						<td>PASSWORD</td>
						<td><input type="password" name="pw" id="pw"></td>
					</tr>
				</table>
				<br>
				<button type="button" id="loginBtn" class="btn btn-info">로그인</button>
				<a href="AddMember" class="btn btn-dark">회원가입</a>
			</fieldset>
		</form>
</body>
	<script>
	$('#loginBtn').click(function(){
		if($('#id').val() == '') {
			window.alert('아이디를 입력하세요');
		} else if ($('#pw').val() == '') {
			window.alert('비밀번호를 입력하세요');
		} else {
			loginForm.submit();
		}
	});
	</script>
</html>
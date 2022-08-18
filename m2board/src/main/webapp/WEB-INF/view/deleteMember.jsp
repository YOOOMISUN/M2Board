<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<form action="DeleteMember" method="post" id="removeForm">
		<p>비밀번호 :  </p>
		<input type="hidden" name="id" value="${loginMember.memberId}">
		<input type="password" name="pw" id="pw">
		<button type="button" id="removebtn">탈퇴하기</button>
		<p><a href="javascript:history.go(-1)" class="btn btn-danger" title="뒤로">뒤로가기</a></p>
	</form>
</body>
<script>	// 유효성 검사
	$('#removebtn').click(function(){
		if($('#pw').val() == '') {
			window.alert('비밀번호를 입력해주세요');
		} else {
			removeForm.submit();
		}
	});
</script>
</html>
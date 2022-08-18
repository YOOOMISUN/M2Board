<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<h1>회원정보수정</h1>
	<form action="UpdateMember" method="post" id="updateForm">
	<table border="1">
		<tr>
			<td>ID</td>	
			<td><input name="id" id="id" value="${loginMember.memberId}" readonly="readonly"></td>
		
		</tr>
		<tr>
			<td>NAME</td>	
			<td><input type="text" id="name" name="name" ></td>	
		
		</tr>
		<tr>
			<td>AGE</td>	
			<td><input type="text" id="age" name="age" ></td>	
		
		</tr>
		<tr>
			<td>GENDER</td>	
			<td>
				<input type="radio" id="gender" name="gender" value="남자">남자
				<input type="radio" id="gender" name="gender" value="여자">여자
			</td>	
		</tr>
		<tr>
			<td>UPDATE DATE</td>	
			<td><input type="text" value="${loginMember.updateDate}" readonly="readonly"></td>	
		</tr>
	</table>
		비밀번호
			<p>PW</p>	
			<input type="password" name="pw" id="pw" >
		<br>
				<button type="button" id="updateMemberBtn">수정하기</button>
				<button type="reset">초기화</button>
	</form>		
</body>
	<script>
	$('#updateMemberBtn').click(function(){
		if($('#name').val() == '') {
			window.alert('이름을 입력하세요!');
		} else if ($('#age').val() == '') {
			window.alert('나이를 입력하세요!');
		} else if ($('#gender').val() == '') {
			window.alert('성별을 입력하세요!');
		} else {
			updateForm.submit();
		}
	});
	</script>
</html>
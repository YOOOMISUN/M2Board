<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>

	<form action="AddMember" method="post" id="addCustomerForm">
		<table border="1">
			<tr>
				<td>Id</td>
				<td><input type="text" name="id" id="id" ></td>
			</tr>
			<tr>
				<td>Pw</td>
				<td><input type="text" name="pw" id="pw" ></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" id="name" ></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="text" name="age" id="age" ></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>		
					<input type="radio" name="gender" id="gender" value="남">남
					<input type="radio" name="gender" id="gender" value="여">여
				</td>
			</tr>
		</table>
			<button type="submit" id="addMemberBtn" class="btn btn-info">회원가입</button>
			<a href="javascript:history.go(-1)" class="btn btn-danger" title="뒤로">BACK</a>
			<a><input type="reset" class="btn btn-success"></a>
			
	</form>
</body>
	<script>
	$('#addMemberBtn').click(function(){
		if($('#id').val() == '') {
			window.alert('아이디를 입력하세요!');
		} else if ($('#pw').val() == '') {
			window.alert('비밀번호를 입력하세요!');
		} else if ($('#name').val() == '') {
			window.alert('이름을 입력하세요!');
		} else if ($('#age').val() == '') {
			window.alert('나이를 입력하세요!');
		} else if ($('#gender').val() == '') {
			window.alert('성별를 입력하세요!');
		} else {
			employeeForm.submit();
		}
	});
	</script>
</html>
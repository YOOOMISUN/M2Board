<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<form action ="${pageContext.request.contextPath}/after/AddBoard" method="post" id="AddBoard">
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" id="title" class="form-control"></td>
			</tr>
			<tr>
				<td>글쓴이</td>
				<td><input type="text" name="writer" class="form-control" value="${loginMember.memberId}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="5" cols="80" class="form-control" name="content" id="content"></textarea></td>
			</tr>
		</table>
			<br>
				<button type="submit" id="addBoardBtn" class="btn btn-info">글쓰기</button>
	</form>
</body>
<script>	// 유효성 검사
	$('#addBoardBtn').click(function(){
		if($('#title').val() == '') {
			window.alert('제목을 입력해주세요');
		} else if($('#content').val() == ''){
			window.alert('내용 입력해주세요');
		} else {
			AddBoard.submit();
		}
	});
</script>	
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div> <!-- 로그인 하면 -->
		${loginMember.memberId}님 반갑습니다.
		<table border='1'>
			<tr>
				<td>Id</td>		<!-- 로그인 아이디 -->
				<td>${loginMember.memberId}</td>
			</tr>
			<tr>
				<td>Name</td>
				<td>${loginMember.memberName}</td>
			</tr>
			<tr>
				<td>Age</td>
				<td>${loginMember.memberAge}</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>${loginMember.memberGender}</td>
			</tr>
		</table>
		
		<br>
		
		<a href="${pageContext.request.contextPath}/after/boardList">게시판</a>
		<a href="${pageContext.request.contextPath}/after/Logout">로그아웃</a>	
		<a href="${pageContext.request.contextPath}/after/UpdateMember">정보수정</a>	
		<a href="${pageContext.request.contextPath}/after/DeleteMember">회원탈퇴</a>
		
		
	</div>
</body>
</html>
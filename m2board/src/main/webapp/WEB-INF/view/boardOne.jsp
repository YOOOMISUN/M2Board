<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시판 상세페이지</h2>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>내용</th>
				<th>작성일</th>
				<th>조회</th>
				<th>좋아요</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="b" items="${list}">
			<td>${loginMember.boardNo}</td>	<!-- b.getBoardNo() -->
			<td>${loginMember.boardTitle}</td>
			<td>${loginMember.boardWriter}</td>
			<td>${loginMember.boardContent}</td>
			<td>${loginMember.creatDate}</td>
			<td>${loginMember.boardRead}</td>
			<td>${loginMember.boardNice}</td>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>
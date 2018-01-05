<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>[springWeb5 - SE Bank Step4]</h1>

	<ul>
		<c:choose>
			<c:when test="${id == null }">
				<li><a href="customer/joinForm">회원 가입</a></li>
				<li><a href="customer/loginForm">로그인</a></li>
			</c:when>
			<c:otherwise>
				<li><h3>${id }(${name })님 환영합니다.</h3></li>
				<li><a href="customer/updateForm">정보수정</a></li>
				<li><a href="customer/logout">로그아웃</a></li>
			</c:otherwise>
		</c:choose>
		<li><a href="board/list">게시판</a></li>
	</ul>

</body>
</html>

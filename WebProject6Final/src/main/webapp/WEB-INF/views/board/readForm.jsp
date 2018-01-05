<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 글 읽기 폼 ]</title>
</head>
<body>
	<h1>[ 게시판 글읽기 ]</h1>
	<table>
		<tr>
			<th>작성자</th>
			<td>${board.id }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${board.inputdate }</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${board.hits }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${board.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><pre>${board.content }</pre></td>
		</tr>
		<tr>
			<th>파일첨부</th>
			<td>미구현</td>
		</tr>
	</table>
	<c:if test="${board.id == id || id == 'admin'}">
		<a href="delete?boardnum=${board.boardnum}">삭제</a>
		<a href="updateForm?boardnum=${board.boardnum}">수정</a>
	</c:if>
	<a href="list">목록보기</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 업데이트 폼 ]</title>
<style type="text/css">
textarea {
	resize: none;
}
</style>
</head>
<body>
	<h1>수정</h1>
	<form action="update" method="post">
		<table>
			<tr>
				<th>작성자</th>
				<td>
					${board.id }
					<input type="hidden" name="boardnum" value="${board.boardnum }">
					<input type="hidden" name="id" value="${board.id }">
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" id="title"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="20" cols="50" name="content" id="content"></textarea>
			</tr>
		</table>
		<input type="submit" value="수정">
	</form>
</body>
</html>
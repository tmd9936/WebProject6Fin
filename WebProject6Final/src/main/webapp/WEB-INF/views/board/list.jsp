<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>[ 글 목록 ]</title>
<script type="text/javascript">
	function writeForm(){
		location.href = "writeForm";
	}
</script>
</head>
<body>
	<h1>[ 글 목록 ]</h1>
	전체 : ${count } &nbsp;&nbsp;&nbsp;&nbsp;
	<c:if test="${id !=null}">
		<input type="button" value="글쓰기" onclick="writeForm()">
	</c:if>
	
	<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>등록일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${list }">
					<tr>
						<td>${board.boardnum }</td>
						<td><a href="read?boardnum=${board.boardnum }">${board.title }</a></td>
						<td>${board.id }</td>
						<td>${board.hits }</td>
						<td>${board.inputdate }</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
	
</body>
</html>
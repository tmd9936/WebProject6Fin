<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>[ 글 쓰기  ]</title>
<style type="text/css">
textarea {
	resize: none;
}
</style>
</head>
<body>
	<h1>[ 글 쓰기 ]</h1>
	<form action="write" method="post">
		<table>
			<tr>
				<th>
					아이디
				</th>
				<td>
					${id }
					<input type="hidden" name="id" id="id" value="${id }">
				</td>
			</tr>
			<tr>
				<th>
					제목
				</th>
				<td>
					<input type="text" name="title" id="title">
				</td>
			</tr>
			<tr>
				<th>
					내용
				</th>
				<td>
					<textarea rows="20" cols="50" name="content" id="content"></textarea>
				</td>
			</tr>
			<tr>
				<th>
					파일첨부
				</th>
				<td>
					<input type="file" name="originalfile" id="originalfil" value=" ">
					<input type="hidden" name="savedfile" id="savedfile" value="">
				</td>
			</tr>
		</table>
		<input type="submit" value="작성">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>[ 로그인 폼 ]</title>
<style type="text/css">
.submit{
	background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
fieldset {
	width: 350px;
	border-radius: 25px;
}
</style>
<script type="text/javascript">
	<c:if test="${msg != null }">
		alert('${msg}');
	</c:if>
	
	function loginCheck(){
		var custid = document.getElementById('custid');
		var password = document.getElementById('password');
		
		if(custid.value == ""){
			alert('입력하세요');
			return false;
		}
		
		if(password.value == ""){
			alert('입력하세요!');
			return false;
		}
		
		return true;
	}
</script>
</head>
<body>
	<h1>[ 로그인 ]</h1>
	<form action="login" method="post" onsubmit="return loginCheck()">
		<fieldset>
			<legend>로그인</legend>
			<table>
				<tbody>
					<tr>
						<td>
							<input type="text" name="custid" id="custid" placeholder="아이디">		
						</td>
						<td rowspan="2">
							<input type="submit" value="로그인" class="submit">
						</td>
					</tr>
					<tr>
						<td>
							<input type="password" name="password" id="password" placeholder="비밀번호"><br>
						</td>
					</tr>
				</tbody>
			</table>
		</fieldset>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 업데이트 ]</title>
<script type="text/javascript">
	function updateCheck() {
		var password = document.getElementById('password');
		var password2 = document.getElementById('password2');
		var name = document.getElementById('name');
		var email = document.getElementById('email');
		var idno = document.getElementById('idno');
		var address = document.getElementById('address');

		if (password.value == "") {
			alert('비밀번호 입력하세요');
			//커서를 여기 위치에 놓는다.
			password.focus();
			return false;
		}

		if (password2.value == "") {
			alert('비밀번호 입력하세요');
			password2.focus();
			return false;
		}

		if (password2.value != password.value) {
			alert('비밀번호가 다릅니다.');
			return false;
		}

		if (name.value == "") {
			alert('이름을 입력하세요');
			return false;
		}

		if (email.value == "") {
			alert('이메일을 입력하세요');
			return false;
		}

		if (idno.value == "") {
			alert('idno를 입력하세요.');
			return false;
		}

		if (address.value == "") {
			alert('주소를 입력하세요.');
			return false;
		}

		return true;
	}
</script>
</head>
<body>
	<h1>[ 업데이트 ]</h1>
	<form action="update" method="post" onsubmit="return updateCheck()">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="hidden" name="custid"
					value="${customer.custid }"> ${customer.custid }</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="password" id="password"><br>
					<input type="password" name="password2" id="password2"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" id="name"
					value="${customer.name }"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email" id="email"
					value="${customer.email }"></td>
			</tr>
			<tr>
				<th>고객 구분</th>
				<td><input type="radio" name="division" value="personal">개인
					<input type="radio" name="division" value="company">기업</td>
			</tr>
			<tr>
				<th>식별번호</th>
				<td>${customer.idno }</td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="address" id="address"
					value="${customer.address }" placeholder="주소 입력"></td>
			</tr>
		</table>
		<input type="submit" value="수정"> <input type="reset"
			value="다시쓰기">
	</form>

	<script type="text/javascript">
		var division = document.getElementsByName('division');
		var custdiv = '${customer.division}';
		//console.log(document.getElementsByName("division")[0].value);
		for (var i = 0; i < division.length; i++) {
			if (division[i].value == custdiv) {
				division[i].checked = true;
			}
		}
	</script>
</body>
</html>
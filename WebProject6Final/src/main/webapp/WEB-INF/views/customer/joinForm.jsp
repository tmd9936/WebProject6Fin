<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	table {
	border: 1px solid black;
	border-collapse: collapse;
	line-height: 2;
	margin: 20px 10px;	
}

table th{
	padding: 10px;
	vertical-align: top;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>[ 회원 가입 폼 ]</title>
	<script type="text/javascript">
		<c:if test="${errorMsg !=null }">
			alert('${errorMsg }');
		</c:if>
	
		function idCheckOpen(){
			//window.name 부모창 이름
			window.name = "joinForm";
			
			//ID중복체크 버튼 클릭시
			//document 변수, location 위치 변경, window 창띄우기
			window.open("idCheck","newWindow","top=300, left=300, width=500,height=300");
			
			
		}
		
		function formCheck(){
			//submit버튼 클릭시
			var custid = document.getElementById('custid');
			var password = document.getElementById('password');
			var password2 = document.getElementById('password2');
			var name = document.getElementById('name');
			var email = document.getElementById('email');
			var idno = document.getElementById('idno');
			var address = document.getElementById('address');
			
			 if(custid.value == ""){
				alert('아이디 입력하세요');
				custid.focus();
				return false;
			} 
			
			if(password.value == ""){
				alert('비밀번호 입력하세요');
				//커서를 여기 위치에 놓는다.
				password.focus();
				return false;
			}
			
			if(password2.value == ""){
				alert('비밀번호 입력하세요');
				password2.focus();
				return false;
			}
			
			if(password2.value != password.value){
				alert('비밀번호가 다릅니다.');
				return false;
			}
			
			if(name.value == ""){
				alert('이름을 입력하세요');
				return false;
			}
			
			if(email.value == ""){
				alert('이메일을 입력하세요');
				return false;
			}
			
			if(idno.value ==""){
				alert('idno를 입력하세요.');
				return false;
			}
			
			if(address.value ==""){
				alert('주소를 입력하세요.');
				return false;
			}
			
			return true;
		}
	</script>
</head>
<body>
	
	<h1>[ 회원 가입 ]</h1>
	<form action="join" method="post" onsubmit="return formCheck()">
		<table>
		<tr>
			<th>ID</th>
			<td>
				<input type="text" name="custid" id="custid" placeholder="ID중복확인 이용" readonly="readonly" value="${customer.custid }"> 
				<input type="button" value="ID중복확인" onclick="idCheckOpen()" >
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" name="password" id="password" placeholder="비밀번호 입력"><br>
				<input type="password" id="password2" placeholder="비밀번호 다시 입력">
			</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>
				<input type="text" name="name" id="name" placeholder="이름 입력" value="${customer.name }">
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>
				<input type="text" name="email" id="email" placeholder="이메일 입력" value="${customer.email }">
			</td>
		</tr>
		<tr>
			<th>고객 구분</th>
			<td>
				<input type="radio" name="division" value="personal" checked="checked">개인 
				<input type="radio" name="division" value="company">기업
			</td>
		</tr>
		<tr>
			<th>식별번호</th>
			<td>
				<input type="text" name="idno" id="idno" value="${customer.idno }" placeholder="개인:주민번호/법인:사업자">
			</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>
				<input type="text" name="address" id="address" value="${customer.address }" placeholder="주소 입력">
			</td>
		</tr>
		
		</table>
		<input type="submit" value="가입"> 
		<input type="reset" value="다시 쓰기">
	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 아이디 중복 검사 ]</title>
<script type="text/javascript">
		function formCheck(){
			var id = document.getElementById('searchId').value;
			
			if(id == ""){
				alert('입력하세요.');
				return false;
			}	
			
			
			for(var i =0; i<id.length; i++){
				var c = id.charAt(i);
				if((c <'a' || c>'z') && (c<'0' || c> '9') && (c<'A' || c>'Z')){
					alert('영문또는 숫자만 가능');
					return false;
				}
			}
			return true;
		}
		
		function useId(id){
			opener.document.getElementById('custid').value = id;
			window.close();
			
		}
	</script>
</head>
<body>
	<h2>[ 아이디 중복 확인 ]</h2>
	<form action="idSearch" method="post" onsubmit="return formCheck()">
		<input type="text" name="searchId" id="searchId" value="${searchId }">
		<input type="submit" value="검색">

		<!-- 검색 유무 확인 -->
		<c:if test="${search }">
			<!-- 검색 결과가 없을 경우 -->
			<c:if test="${searchResult == null }">
				<p>${searchId }:사용할 수 있는 ID입니다.</p>
				<br>
				<input type="button" value="ID사용하기" onclick="useId('${searchId }')">
			</c:if>

			<!-- 검색 결과가 있을 경우 -->
			<c:if test="${searchResult != null }">
				<p>${searchId }:이미 사용중인 ID입니다.</p>
			</c:if>
		</c:if>
	</form>
</body>
</html>
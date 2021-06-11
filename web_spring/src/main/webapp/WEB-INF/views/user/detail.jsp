<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<label for="id_nickname">닉네임</label>
		<input id="id_nickname" type="text" name="nickname" value="${requestScope.account.getNickname() }">
		<button type="button" onclick="nicknameCheck('${nickname_check }', document.getElementById('id_nickname').value);">중복확인</button>
		<label id="nickname_check_res"></label>
	</div>
	<div>
		<label for="id_username">이름</label>
		<input id="id_username" type="text" name="username" value="${requestScope.account.getUsername() }" disabled>
	</div>
	<div>
		<label for="id_email">이메일</label>
		<input id="id_email" type="text" name="email" value="${requestScope.account.getEmail() }" disabled>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<c:url var="board" value="/board" />
<c:url var="join" value="/account/join" />
<body>
	<h1>Main Page</h1>
	<ul>
		<li><a href="${board }">게시판으로 이동</a></li>
		<li><a href="${join }">회원가입</a></li>
	</ul>
</body>
</html>
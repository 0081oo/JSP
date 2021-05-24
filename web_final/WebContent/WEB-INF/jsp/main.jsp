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
<c:url var="login" value="/account/login" />
<c:url var="logout" value="/account/logout" />
<c:url var="join" value="/account/join" />
<c:url var="info" value="/account/info" />
<body>
	<h1>Main Page</h1>
	<ul>
		<li><a href="${board }">게시판으로 이동</a></li>
		<c:choose>
			<c:when test="${sessionScope.logined }">
				<li><a href="${logout }">로그아웃</a></li>
				<li><a href="${info }">회원정보</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${login }">로그인</a></li>
				<li><a href="${join }">회원가입</a></li>
			</c:otherwise>
		</c:choose>
		
	</ul>
</body>
</html>
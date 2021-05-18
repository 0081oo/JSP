<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 내장객체</title>
</head>
<body>
	<h1>request 내장 객체</h1>
	<ul>
		<li><%=request.getAttribute("name") %></li>
		<li>${requestScope.name }</li>
	</ul>
	
	<h1>session 내장 객체</h1>
	<ul>
		<li><%=session.getAttribute("name") %></li>
		<li>${sessionScope.name }</li>
	</ul>
</body>
</html>
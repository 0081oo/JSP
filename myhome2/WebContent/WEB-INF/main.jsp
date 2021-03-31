<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="board" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/static/bootstrap-4.6.0/css/bootstrap.min.css">
<script type="text/javascript" src="<%=request.getContextPath() %>/static/bootstrap-4.6.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/static/jquery/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<header>
		<%@ include file="/WEB-INF/module/top_nav.jsp" %>
	</header>
	<h1>환영합니다</h1>
	<ul>
		<li><a href="./gugudan">구구단</a></li>
		<li><a href="./member?name=admin">Member</a></li>
		<li><a href="./visit?id=00000002">Visit</a></li>
		<li><a href="./board">board DB</a></li>
	</ul>
</body>
</html>
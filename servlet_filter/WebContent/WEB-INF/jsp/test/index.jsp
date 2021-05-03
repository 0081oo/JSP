<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Response Completed</title>
</head>
<body>
	<h1>응답완료!</h1>
	<p><%= request.getParameter("name") %></p>
	
	<form action="<%=request.getContextPath() %>/test/a" method="post">
		<input type="text" name="name">
		<button type="submit">TestA send</button>
	</form>
	
	<form action="<%=request.getContextPath() %>/test/b" method="post">
		<input type="text" name="name">
		<button type="submit">TestB send</button>
	</form>
</body>
</html>
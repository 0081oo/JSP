<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>구구단 출력</h1>
	<%
		ArrayList<String> res = (ArrayList)request.getAttribute("gugu_res");
	%>
	<ul>
		<% for(String v: res) { %>
			<li><%=v %></li>
		<% } %>
	</ul>
</body>
</html>
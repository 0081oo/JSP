<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" import="member.VisitVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VISIT</title>
</head>
<body>
	<h1>방명록</h1>
	<form action="./visit" method="post">
	
	</form>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>내용</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<% ArrayList<VisitVO> result = (ArrayList<VisitVO>)request.getAttribute("result");
			for(VisitVO data: result) {%>
			<tr>
				<td><%=data.getId() %></td>
				<td><%=data.getContext() %></td>
				<td><%=data.getAuthor() %></td>
				<td><%=data.getCreate_date() %></td>
			</tr>
		<% } %>
	</table>
	
</body>
</html>
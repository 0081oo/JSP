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
	<form action="./visit" method="post"><br>
		<input type="text" name="author" placeholder="작성자" required><br>
		<textarea name="content" required></textarea><br>
		<button type="submit">작성</button><br>
	</form>
	<hr>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>내용</th>
			<th>작성자</th>
			<th>작성일</th>
			<th></th>
		</tr>
		<% ArrayList<VisitVO> result = (ArrayList<VisitVO>)request.getAttribute("result");
			for(VisitVO data: result) {%>
			<tr>
				<td><%=data.getId() %></td>
				<td><a href="./update?id=<%=data.getId()%>"><%=data.getContent() %></a></td>
				<td><%=data.getAuthor() %></td>
				<td><%=data.getCreate_date() %></td>
				<td><form action="./delete" method="post">
					<input type="hidden" name="id" value= "<%=data.getId() %>" readonly>
					<button type="submit">삭제</button>
				</form></td>
			</tr>
		<% } %>
	</table>
	
</body>
</html>
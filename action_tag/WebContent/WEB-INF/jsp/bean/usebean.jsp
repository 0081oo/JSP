<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bean 사용예제</title>
</head>
<body>
	<form action="<%= request.getContextPath()%>/bean" method="post">
		<div>
			<label>이름 : </label>
			<input type="text" name="name">
		</div>
		<div>
			<label>나이 : </label>
			<input type="number" name="age">
		</div>
		<div>
			<label>성별 : </label>
			<input type="text" name="gender">
		</div>
		<div>
			<label>이메일 : </label>
			<input type="email" name="email">
		</div>
		<div>
			<button type="submit">전송</button>
		</div>
	</form>
</body>
</html>
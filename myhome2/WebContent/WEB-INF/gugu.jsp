<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gugudan</title>
</head>
<body>
	<h1>구구단 단을 입력하세요</h1>
	<form action="./gugudan" method="post">
        <input type="number" name="dan_num" min="1" max="100" value="1">
        <button type ="submit">입력</button>
    </form>
</body>
</html>
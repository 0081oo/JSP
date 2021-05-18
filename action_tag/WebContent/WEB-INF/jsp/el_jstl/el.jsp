<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 예제</title>
</head>
<body>
	<ul>
		<li>10 + 15 = ${10+15 }</li>
		<li>20 / 4 = ${20/4 }</li>
<%-- 		<li>20 / 4 = ${20 div 4 }</li> --%>
		<li>20 % 4 = ${20 mod 4 }</li>
		<li>20 % 4 = ${20%4 }</li>
		<li>a == b -> ${"a" == "b"}</li>
		<li>a eq b -> ${"a" eq "b"}</li>
<%-- 		<li>a ne b -> ${"a" ne "b"}</li> --%>
		
		<!-- eq, nq, ge, le, gt, lt -->
	</ul>
</body>
</html>
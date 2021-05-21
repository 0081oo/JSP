<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 포맷 / function 사용법</title>
</head>
<body>
	<h1>숫자 표현 포맷</h1>
	<c:set var="num1" value="1234.567" />
	<c:set var="num2" value="0.5" />
	<h4><fmt:formatNumber value="${num1 }" type="number" /></h4>
	<h4><fmt:formatNumber value="${num1 }" type="number" groupingUsed="false" /></h4>
	<hr>
	<h4><fmt:formatNumber value="${num1 }" type="currency" /></h4> <!-- 통화 -->
	<h4><fmt:formatNumber value="${num2 }" type="percent" /></h4> <!-- 퍼센트 -->
	<hr>
	<h4><fmt:formatNumber value="${num1 }" type="currency" maxFractionDigits="2" /></h4>
	<h4><fmt:formatNumber value="${num2 }" type="percent" maxFractionDigits="4" /></h4>
	<h4><fmt:formatNumber value="${num2 }" type="number" maxFractionDigits="4" pattern="0000.0000" /></h4>
	<hr>
	<h4><fmt:formatNumber value="${num1 }" type="currency" /></h4>
	<fmt:setLocale value="en_US" />
	<h4><fmt:formatNumber value="${num1 }" type="currency" /></h4>
	
	<h1>Function</h1>
	
</body>
</html>
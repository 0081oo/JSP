<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 사용법</title>
</head>
<body>
	<h1>변수 설정</h1>
	<c:set var="path" value="${pageContext.request.contextPath }" />
	<h3>path -> ${path }</h3>
	
	<c:set var="number1" value="100" />
	<h3>number1 -> ${number1 }</h3>
	
	<h1>변수 생성할 때 스코프 지정</h1>
	<c:set var="p_var" value="page_scope" scope="page" />
	<h3>p_var -> ${p_var }</h3>
	
	<c:set var="p_req" value="request_scope" scope="request" />
	<h3>p_req -> ${p_req }</h3>
	<h3>p_req -> ${requestScope.p_req }</h3>
	
	<c:set var="p_ses" value="session_scope" scope="session" />
	<h3>p_ses -> ${p_ses }</h3>
	<h3>p_ses -> ${sessionScope.p_ses }</h3>
	
	<h1>배열 생성</h1>
	<c:set var="arr">
		a, b, c
	</c:set>
	<h3>arr -> ${arr }</h3>
	
	<h1>제어문</h1>
	<c:if test="${number1 >= 100 }" <%-- var="변수명" --%>>
		number1 은 100 보다 크거나 같다.
	</c:if>
	
	<h1>제어문 if ~ else</h1>
	<c:choose>
		<c:when test="${number1 lt 100 }">
			number1 은 100 보다 크거나 같다.
		</c:when>
		<c:otherwise>
			number1 은 100 보다 작다.
		</c:otherwise>
	</c:choose>
	
	<h1>반복문 for문</h1>
	<c:forEach var="i" begin="0" end="9">
		<li>${i }</li>
	</c:forEach>
	
	<h1>반복문 for문</h1>
	<c:forEach var="i" begin="0" end="9" step="2"> <!-- 2씩증가 -->
		<li>${i }</li>
	</c:forEach>
	
	<hr>
	
	<ul>
		<c:forEach var="i" items="${arr }">
			<li>${i }</li>
		</c:forEach>
	</ul>
	
	<ul>
		<c:forEach var="i" items="${arr }" varStatus="loop"> <!--  반복횟수  -->
			<li>${loop.index} -${loop.count} - ${i }</li>
		</c:forEach>
	</ul>
</body>
</html>
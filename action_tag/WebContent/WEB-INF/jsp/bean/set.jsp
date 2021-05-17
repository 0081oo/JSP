<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="action.tag.SampleVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bean으로 객체 생성</title>
</head>
<body>
	<!-- UseBean을 안쓴다면 -->
	<%--
		SampleVO data = new SampleVO();
		data.setName((String)request.getParameter("name"));
		data.setAge(Integer.parseInt(request.getParameter("age")));
		data.setGender((String)request.getParameter("gender"));
		data.setEmail((String)request.getParameter("email"));
	--%>
	<jsp:useBean id="data" class="action.tag.SampleVO"/>
	<%-- <jsp:setProperty property="name" name="data" value="<%=(String)request.getParameter(\"name\")%>"/> --%>
	<!-- 이렇게 param만 작성해도 동작함/ 근데 usebean jsp에서 지정한 name이랑 여기서 property에 지정한걸아 같으면 param도 할 필요 없음 -->
	<jsp:setProperty property="name" name="data" param="name"/> 
	<jsp:setProperty property="age" name="data" value="<%=Integer.parseInt(request.getParameter(\"age\"))%>"/>
	<jsp:setProperty property="gender" name="data" value="<%=(String)request.getParameter(\"gender\")%>"/>
	<jsp:setProperty property="email" name="data" value="<%=(String)request.getParameter(\"email\")%>"/>
	
	<h1>사용자 입력 정보를 잘 전달 받았습니다.</h1>
<%-- 	<p><%=data.getName() %></p>
	<p><%=data.getAge() %></p>
	<p><%=data.getGender() %></p>
	<p><%=data.getEmail() %></p> --%>
	<p><jsp:getProperty property="name" name="data"/></p>
	<p><jsp:getProperty property="age" name="data"/></p>
	<p><jsp:getProperty property="gender" name="data"/></p>
	<p><jsp:getProperty property="email" name="data"/></p>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="top_menu.jsp" %>
메인페이지입니다.
<br>
<c:choose>
	<c:when test="${empty sessionScope.userid}">
	${sessionScope.userid} 쇼핑몰에 오신 것을 환영합니다.
	</c:when>
	<c:when test="${!empty sessionScope.userid}">
	${sessionScope.userid}고객님 환영합니다.
	</c:when>
</c:choose>

</body>
</html>
<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
		<h2>상품자료(JdbcDaoSupport)</h2>
		<table border="1">
			<tr>
				<th>code</th>
				<th>sang</th>
				<th>su</th>
				<th>dan</th>
			</tr>
<c:forEach var="s" items="${message}">
			<tr>
				<td>${s.code }</td>
				<td>${s.sang }</td>
				<td>${s.su }</td>
				<td>${s.dan }</td>
			</tr>
</c:forEach>
		</table>
	</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
#wrapper{
width: 1000px;
margin: 0 auto;
border:1px solid #000;
}
td{
text-align: center;
}
</style>
<title>상품 리스트</title>
</head>
<body>
<%-- <%@include file="session_check.jsp"%> --%>
<div id="wrapper">
<a href="main.do">돌아가기</a>
<h3 style="text-align: center;">상 품 리 스 트</h3>
<table width="100%">
	<tr>
		<th>상품번호</th><th>상품명</th><th>가격</th><th>재고</th><th>이미지</th>
	</tr>
<c:forEach var="p" items="${plist}">
	<tr>
		<td>${p.no}</td>
		<td>${p.name}</td>
		<td>${p.price}</td>
		<td>${p.stock}</td>
		<td><a href="detailform.do?no=${p.no}"><img src="${p.imgsrc}"></a></td>
	</tr>
</c:forEach>
</table>
</div>
</body>
</html>
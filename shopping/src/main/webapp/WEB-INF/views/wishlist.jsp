<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
String user_id = (String)session.getAttribute("userid");
%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
	function funcBuy(){
 		location.href="buy"
	}
	function funcDel(a){
		$('#product_no').val(a);
		var id = $('#product_no').attr('value');
		//alert(id)
		frm.submit();
	}
	function funcSu(a,b){
		var su = $(a).val();
		location.href="wish_update.do?su="+su+"&product_no="+b
	}
</script>
<style type="text/css">
#wrapper{
width: 1000px;
margin: 0 auto;
border: 1px solid #000;
}
td{
text-align: center;
}
</style>
<title>위시리스트</title>
</head>
<body>
<div id="wrapper">
<a href="main.do">돌아가기</a>
<h3 style="text-align: center;">위 시 리 스 트</h3>
<%
if(user_id == null || user_id.equals(null)){
%>
<h4 style="text-align: center;"><a href="login.do">로그인 하기</a></h4>
<%
}else{
%>

<table width="100%">
	<tr>
		<th>상품명</th><th>가격</th><th>수량</th><th>이미지</th><th>옵션</th>
	</tr>
<c:forEach var="w" items="${wlist}" varStatus="n">
	<tr>
		<td>${w.name}</td>
		<td>${w.price}</td>
		<td>
		<input type="number" id="su" name="su" value="${w.su}" style="text-align:center; width:50px" 
			onchange="javascript:funcSu(this,${w.no})">
		</td>
		<td><img src="${w.imgsrc}"></td>
		<td>
		<button onclick="javascript:funcBuy()">구매</button>/
		<button onclick="javascript:funcDel(${w.no})">삭제</button>
		</td>
	</tr>
</c:forEach>
</table>
<%	
}
%>
<form action="wish_delete.do" name="frm" method="get">
<input type="hidden" name="product_no" id="product_no">
</form>
</div>
</body>
</html>
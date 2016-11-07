<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
	function funcWish(){
		alert("장바구니에 추가되었습니다.");
		var imsi = $('#su').attr('value')
		frm.submit();
	}
	function funcBuy(){
		location.href="buy"
	}
	function funcBack(){
		location.href="product"
	}
	function change(a){
		var su1 = $(a).val();
		$('#su').val(su1)
		var su2 = $('#su').attr('value')
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
<title>${dlist.name} 자세하게 보기</title>
</head>
<body>
<a href="main.do">돌아가기</a>
<div id="wrapper">
<h3 style="text-align: center;">${dlist.name} 자세하게 보기</h3>
<table width="100%">
	<tr>
		<td colspan="5" style="font-size: 20px; text-align: center;">
		<button onclick="javascript:funcWish()">장바구니에 담기</button>&nbsp;&nbsp;
		<button onclick="javascript:funcBuy()">바로 구매하기</button>&nbsp;&nbsp;
		<button onclick="javascript:funcBack()">상품 보기</button>
		</td>
	</tr>
	<tr><td colspan="5">-----</td></tr>
	<tr>
		<th>상품번호</th><th>상품명</th><th>가격</th><th>주문수량/재고</th><th>이미지</th>
	</tr>

	<tr>
		<td>${dlist.no}</td>
		<td>${dlist.name}</td>
		<td>${dlist.price}</td>
		<td>
		<input type="number" id="number" name="number" style="text-align:center; width:50px" 
		onchange="javascript:change(this)">&nbsp;/
		${dlist.stock}
		</td>
		<td><img src="${dlist.imgsrc}"></td>
	</tr>
</table>
</div>
<form action="wish_insert.do" name="frm">
<input type="hidden" value="${dlist.no}" name="product_no">
<input type="hidden" id="su" name="su">
</form>
</body>
</html>
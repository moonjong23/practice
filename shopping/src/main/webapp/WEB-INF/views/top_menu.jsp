<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	String logincheck = "";
	String user_id = (String)session.getAttribute("userid");
	if(user_id == null){
		logincheck = "로그인";
	}else{
		logincheck = "로그아웃";		
	}
%>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">


</script>
</head>
<body>
<div class="row">
  <div class="col-md-2"><h3><p class="text-center"><a href="product.do">상품리스트</a></p></h3></div>
  <div class="col-md-2"><h3><p class="text-center"><a href="order.do">주문내역</a></p></h3></div>
  <div class="col-md-2"><h3><p class="text-center"><a href="wish.do">장바구니 가기</a></p></h3></div>
  <div class="col-md-2"><h3><p class="text-center"><a href="mypage.do">마이페이지</a></p></h3></div>
  <div class="col-md-2"><h3><p class="text-center"><a href="board.do">게시판</a></p></h3></div>
<%
  if(logincheck.equals("로그인")){
%>
<div class="col-md-2"><h3><p class="text-center"><a href="login.do"><%=logincheck %></a></p></h3></div>
<%	  
  }else{
%>
  <div class="col-md-2"><h3><p class="text-center"><a href="logout.do"><%=logincheck %></a></p></h3></div>
<%
  }
 %>
</div>
<hr>
</body>
</html>
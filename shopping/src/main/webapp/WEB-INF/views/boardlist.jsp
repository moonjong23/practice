<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
function funcI(){
	location.href="b_insertform.do";
}

function funcD(num,passwd){
	if(confirm("정말 삭제하시겠습니까?") == true){
		location.href="b_delete.do?num="+num
	}else{
		alert("취소하였습니다.");
	}
}
</script>
<title>게시판</title>
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
</head>
<body>
<div id="wrapper">
<h2 style="text-align: center;">게 시 판</h2>
<a href="main.do">돌아가기</a>&nbsp;
<c:choose>
	<c:when test="${total eq 0}">
		게시글이 없습니다. <br>
		<a href="javascript:funcI()">새 글 쓰기</a>&nbsp;
	</c:when>
	<c:when test="${total > 0 }">
<a href="javascript:funcI()">새 글 쓰기</a>&nbsp;

<hr>
<table id="tbl" width="100%">
	<tr>
		<th>번호</th><th>제목</th><th>닉네임</th><th>내용</th><th>조회수</th><th>작성일</th><th>옵션</th>
	</tr>
<c:forEach var="b" items="${blist}">
	<tr>
		<td>${b.num}</td>
		<td><a href="#">${b.title}</a></td>
		<td>${b.name}</td>
		<td>${b.content}</td>
		<td>${b.readcnt}</td>
		<td>${b.date}</td>
		<td><a href="#">수정</a> / <a href="javascript:funcD(${b.num})">삭제</a></td>
	</tr>
</c:forEach>
	<tr> <!-- 페이징처리 -->
		<td colspan="7" style="text-align: center;">
		<%-- <c:set value="${(total-1)/pageSize + 1 }" var="pageTotal"/> --%>
		<c:forEach var="p" begin="1" end="${totalPage}">	
			<c:if test="${currentPage == p}">${p}</c:if>
			<c:if test="${currentPage != p }">
				<a href="board.do?pagenum=${p}">${p}</a>
			</c:if> 
		</c:forEach>
		</td>
	</tr>
</table>
</c:when>
</c:choose>
</div>
<form action="frm">
<input type="hidden" name="userid">
</form>
</body>
</html>
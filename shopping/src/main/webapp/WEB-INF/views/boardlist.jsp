<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="<c:url value='/js/common.js'/>" charset="utf-8"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<title>게시판</title>
<style type="text/css">
	.wrapper{
	width: 1000px;
	height: 900px;
	margin: 0 auto;
	border: 1px solid #000;
	}
	td{
	text-align: center;
	}
	th{
	text-align: center;}
	
	.wrapper2{
	width: 1000px;
	height: 60px;
	margin: 0 auto;
	border: 1px solid #000;
	}
</style>
</head>
<body>
<div class="wrapper">
	<h2 style="text-align: center;">게 시 판</h2>

	&nbsp;<a href="main.do">돌아가기</a>&nbsp;
<c:choose>
	<c:when test="${totalCount eq 0}">
		게시글이 없습니다. <br>
		<a href="javascript:funcI()">새 글 쓰기</a>&nbsp;

	</c:when>
	<c:when test="${totalCount > 0 }">
&nbsp;<a href="javascript:funcI()">새 글 쓰기</a><br>
&nbsp;<input type="text" id="pageSize" size="3px" value="${pageSize}"> &nbsp;put pageSize
<input type="text" id="blockSize" size="5px" value="${blockSize}"> &nbsp;put blockSize
<input type="button" id="sizeSubmit" value="변경" onclick="javascript:funcSizeSubmit()">&nbsp;
<input type="text" id="sDateText" size="10px" value="${s_Date}" > ex)YYYY ~
<input type="text" id="eDateText" size="10px" value="${e_Date}" > ex)YYYY
<input type="button" id="dateSearch" value="년도별 검색" onclick="javascript:funcDateSearch()">&nbsp;


<hr>
<table width="100%">
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
</table>
</c:when>
</c:choose>
</div>
	<div class="wrapper2">
		<!-- 페이징처리 -->
		<div class="row">
			<div class="col-md-7 col-md-offset-5">
			<c:forEach var="p" begin="${startBlockPage}" end="${endBlockPage}">
				<c:if test="${currentPage == p}">
				[${p}]
				<input type="hidden" id="pagenum" name="pagenum" value="${p}">
				</c:if>
				<c:if test="${currentPage != p }">
					<a href="javascript:funcClickPage('${p}')">[${p}]</a>

				</c:if>
			</c:forEach>
			</div>
		</div>
		<div class=row>
			<div class="col-md-2">
			<c:if test="${currentPage != 1}">
				<a href="javascript:funcFirst()">[첫 페이지]</a>
			</c:if>
			<c:if test="${currentPage == 1}">
				[첫 페이지]
			</c:if>
			</div>
			<div class="col-md-2">
			<c:if test="${currentBlock != 1}">
				<a href="javascript:funcPB()">[이전 블록]</a>
			</c:if>
			<c:if test="${currentBlock == 1}">
				[이전 블록]
			</c:if>
			</div>
			<div class="col-md-2">
			<c:if test="${currentPage != 1 }">
				<a href="javascript:funcP()">[이전 페이지]</a>
			</c:if>
			<c:if test="${currentPage == 1 }">
				[이전 페이지]
			</c:if>
			</div>
			<div class="col-md-2">
			<c:if test="${currentPage != totalPage}">
				<a href="javascript:funcN();">[다음 페이지]</a>
			</c:if>
			<c:if test="${currentPage == totalPage}">
				[다음 페이지]
			</c:if>
			</div>
			<div class="col-md-2">
			<c:if test="${currentBlock != totalBlock }">
				<a href="javascript:funcNB()">[다음 블록]</a>
			</c:if>
			<c:if test="${currentBlock == totalBlock }">
				[다음 블록]
			</c:if>
			</div>
			<div class="col-md-2">
			<c:if test="${currentPage != totalPage }">
				<a href="javascript:funcLast()">[마지막 페이지]</a>
			</c:if>
			<c:if test="${currentPage == totalPage }">
				[마지막 페이지]
			</c:if>
			</div>
		</div>
	</div>
<input type="hidden" id="currentPage" name="currentPage" value="${currentPage}">
<input type="hidden" id="startBlockPage" name="startBlockPage" value="${startBlockPage}">
<input type="hidden" id="endBlockPage" name="endBlockPage" value="${endBlockPage}">
<input type="hidden" id="blockSize" name="blockSize" value="${blockSize}">
<input type="hidden" id="totalPage" name="totalPage" value="${totalPage}">
</body>
</html>
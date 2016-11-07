<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 새 글 작성</title>
</head>
<body>
<h3>게시판 새 글 작성</h3>
<form action="b_insert.do" method="post" name="frm">
닉네임: <input type="text" name="name"><br>
패스워드: <input type="text" name="passwd"><br>
제목: <input type="text" name="title"><br>
내용: 
<textarea name="content" rows="5" cols="40"></textarea><br>
<input type="submit" value="새 글 등록">&nbsp;
<input type="reset" value="다시 쓰기">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
** 이메일 작성 후 전송 **<p>
<form action="send" method="post">
이메일 : <input type="email" name="receiver" placeholder="abc@abc.com"><br/> <!-- email과 placeholder : HTML5 부터 지원 -->
글제목: <input type="text" name="subject"><br>
글내용: <textarea rows="5" cols="50" name="content"></textarea><p/>
<input type="submit" value="전송~">
</form>
</body>
</html>
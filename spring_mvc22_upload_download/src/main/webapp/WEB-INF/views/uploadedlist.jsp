<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>** 업로드된 파일 정보 **</b>
파일명 : ${filename} <br>
<form action="download" method="post">
<input type="hidden" name="filename" value="${filename}">
<input type="submit" value="다운로드">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
**파일업로드 / 다운로드**<br/>
<frm:form enctype="multipart/form-data" modelAttribute="uploadBean">
<input type="file" name="file"><br/>
<frm:errors path="file" cssStyle="color:red"/><p/>
<input type="submit" value="전송">
</frm:form>
</body>
</html>
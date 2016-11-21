<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="spr" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta charset="utf-8">
<title>Welcome</title>
</head>
<body>
자료 입력 : spring tag<br>
<spr:form commandName="command">
I D : <spr:input path="Userid"/> <spr:errors path="Userid"/><br>
PWD : <spr:password path="Passwd"/> <spr:errors path="Passwd"/><br>
<input type="submit" value="전송">
</spr:form>
</body>
</html>
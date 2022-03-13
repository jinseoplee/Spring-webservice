<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
	<p>아이디 : ${user.id}</p>
	<p>이메일 : ${user.email}</p>
	<p>이름 : ${user.name}</p>
	<p>가입일 : <tf:formatDateTime value="${user.createDate}" pattern="yyyy-MM-dd HH:mm"/></p>
</body>
</html>
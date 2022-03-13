<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
</head>
<body>
	<h1>Index Page</h1>
	<c:if test="${empty authInfo}">
		<a href="<c:url value="/login"/>">[로그인]</a>
		<a href="<c:url value="/register"/>">[회원가입]</a>
	</c:if>
	<c:if test="${!empty authInfo}">
		<p><strong>${authInfo.name}</strong>님 안녕하세요</p>
		<a href="<c:url value="/logout"/>">[로그아웃]</a>
		<a href="<c:url value="/edit/changePassword"/>">[비밀번호 변경]</a>
	</c:if>
</body>
</html>
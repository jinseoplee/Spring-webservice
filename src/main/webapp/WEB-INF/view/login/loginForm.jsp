<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <form:form modelAttribute="loginRequest">
        <div>
            <label for="email">이메일</label><br>
            <form:input path="email"/>
            <form:errors path="email" />
        </div>
        <div>
            <label for="password">비밀번호</label><br>
            <form:password path="password"/>
            <form:errors path="password" />
        </div>
        <div>
        	<label for="rememberEmail">이메일 기억하기</label>
        	<form:checkbox path="rememberEmail"/>
        </div>
        <div>
            <form:errors />
        </div>
        <input type="submit" value="로그인" />
    </form:form>
</body>
</html>
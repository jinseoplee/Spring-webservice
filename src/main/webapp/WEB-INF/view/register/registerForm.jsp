<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
</head>
<body>
    <h2>회원 정보 입력</h2>
    <form:form modelAttribute="registerRequest">
        <div>
            <label for="email">이메일</label><br>
            <form:input path="email"/>
            <form:errors path="email"/>
        </div>
        <div>
            <label for="name">이름</label><br>
            <form:input path="name"/>
            <form:errors path="name"/>
        </div>
        <div>
            <label for="password">비밀번호</label><br>
            <form:password path="password"/>
            <form:errors path="password"/>
        </div>
        <div>
            <label for="confirmPassword">비밀번호 확인</label><br>
            <form:password path="confirmPassword"/>
            <form:errors path="confirmPassword"/>
        </div>
        <input type="submit" value="가입" />
    </form:form>
</body>
</html>
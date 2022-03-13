<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
</head>
<body>
	<form:form modelAttribute="changePasswordRequest">
		<div>
			<label for="currentPassword">현재 비밀번호</label>
			<input type="text" name="currentPassword" id="currentPassword"/>
			<form:errors path="currentPassword"/>
		</div>
		<div>
			<label for="newPassword">새 비밀번호</label>
			<input type="text" name="newPassword" id="newPassword"/>
			<form:errors path="newPassword"/>
		</div>
		<div>
			<label for="confirmNewPassword">새 비밀번호 확인</label>
			<input type="text" name="confirmNewPassword" id="confirmNewPassword"/>
			<form:errors path="confirmNewPassword"/>
		</div>
		<input type="submit" value="변경"/>
	</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 조회</title>
</head>
<body>
	<h2>회원 조회</h2>
	<form:form modelAttribute="userListRequest">
		<p>
			<label for="from">From</label>
			<form:input path="from" placeholder="yyyymmddhh"/>
			<form:errors path="from"/>
			~
			<label for="to">To</label>
			<form:input path="to" placeholder="yyyymmddhh"/>
			<form:errors path="to"/>
			<input type="submit" value="조회"/>
		</p>
	</form:form>
	
	<c:if test="${!empty userList}">
		<table>
			<tr>
				<th>아이디</th>
				<th>이메일</th>
				<th>이름</th>
				<th>가입일</th>
			</tr>
			<c:forEach var="user" items="${userList}">
			<tr>
				<td><a href="<c:url value="/user/${user.id}"/>">${user.id}</a></td>
				<td>${user.email}</td>
				<td>${user.name}</td>
				<td><tf:formatDateTime value="${user.createDate}" pattern="yyyy-MM-dd"/></td>
			</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>

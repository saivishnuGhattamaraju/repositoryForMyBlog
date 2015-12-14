<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Security Question</title>
</head>
<body>
	<form:form action="verifySecurityQuestion" method="post"
		name="userProfile" commandName="userProfile" modelAttribute="userProfile">
		<c:forEach items="${userProfile.securityQuesionAndAnswer}" var="qna" varStatus="status">
        <tr>
            <td>${qna.key}?</td>
            <td><input value="${qna.value}"/></td>
        </tr>
    	</c:forEach>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>
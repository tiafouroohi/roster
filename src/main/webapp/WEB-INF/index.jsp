<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>New Student</h1>

<form:form action="/" method="post" modelAttribute="student">
<p>
<form:label path="firstName">First Name</form:label>
<form:errors path="firstName"></form:errors>
<form:input path="firstName"></form:input>
</p>
<p>
<form:label path="lastName">Last Name</form:label>
<form:errors path="lastName"></form:errors>
<form:input path="lastName"></form:input>
</p>
<p>
<form:label path="age">Age</form:label>
<form:errors path="age"></form:errors>
<form:input path="age"></form:input>
</p>

<input type="submit" value="Submit"/>

</form:form>

</body>
</html>
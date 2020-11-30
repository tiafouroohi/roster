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

<h1>Contact Info</h1>

<form:form action="/contact" method="post" modelAttribute="contact">

<form:label path="student">Student</form:label>
<form:select path="student">
<c:forEach items="${students }" var="student">
<form:option value="${student}">${student.firstName }</form:option>
</c:forEach>
</form:select>
<p>
<form:label path="address">Address</form:label>
<form:errors path="address"></form:errors>
<form:input path="address"></form:input>
</p>
<p>
<form:label path="city">City</form:label>
<form:errors path="city"></form:errors>
<form:input path="city"></form:input>
</p>
<p>
<form:label path="state">State</form:label>
<form:errors path="state"></form:errors>
<form:input path="state"></form:input>
</p>
<input type="submit" value="Submit"/>

</form:form>

</body>
</html>
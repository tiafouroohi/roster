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

<h1>Create Dorm</h1>

<form:form action="/dorm" method="post" modelAttribute="dorm">
<p>
<form:label path="name">Name:</form:label>
<form:errors path="name"></form:errors>
<form:input path="name"></form:input>
</p>


<input type="submit" value="Submit"/>

</form:form>

</body>
</html>
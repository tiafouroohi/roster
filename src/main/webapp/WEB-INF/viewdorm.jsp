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

<h1><c:out value="${dorm.name }"></c:out></h1>

<form action="/dorm/${dorm.id}" method="post">

<label path="student">Student</label>
<select name="studentId">


<c:forEach items="${students }" var="student">
<option value="${student.id}">${student.firstName }</option>
</c:forEach>
</select>
<input type="submit" value="Submit"/>

<h1><c:out value="${dorm.name }"></c:out>'s Students</h1>

<c:forEach items="${dorm.student }" var="student">

<c:out value="${student.firstName}"></c:out>


</c:forEach>

</form>

</body>
</html>
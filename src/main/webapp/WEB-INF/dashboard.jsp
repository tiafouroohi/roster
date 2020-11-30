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

<c:forEach items="${allStudents }" var="student">

<h1><c:out value="${student.firstName }"></c:out></h1>
<h3><c:out value="${student.age }"></c:out></h3>
<h4><c:out value="${student.contact.address }"></c:out></h4>
<h4><c:out value="${student.contact.city }"></c:out></h4>
<h4><c:out value="${student.contact.state}"></c:out></h4>
</c:forEach>






</body>
</html>
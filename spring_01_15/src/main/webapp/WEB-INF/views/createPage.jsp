<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="student/create">
		이름: <input type="text" name="name" value="${ student.name }"> <br />
		아이디: <input type="text" name="id" value="${ student.id }"> <br />
		<input type="submit" value="전송">
	</form>
</body>
</html>
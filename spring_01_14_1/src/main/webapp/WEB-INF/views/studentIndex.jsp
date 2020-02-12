<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<%
		String context = request.getContextPath();
	%>
	
	<form action="<%=context%>"/studentView method="post">
		이름 : <input type="text" name="name"> <br />
		나이 : <input type="age" name="age"> <br />
		학년 : <input type="classNum" name="classNum"> <br />
		반 : <input type="gardeNum" name="gardeNum"> <br />
		<input type="submit" value="전송">
	</form>
</body>
</html>

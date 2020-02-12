<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<%-- 이름 : ${ memeber.name } <br /> --%>
	아이디 : ${ memeber.id } <br />
	비밀번호 : ${ memeber.pw } <br />
	<%-- 메일 : ${ memeber.email }  --%>
</body>
</html>

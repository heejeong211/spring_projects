<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	이름 : ${ studentInfo.name } <br />
	나이 : ${ studentInfo.age } <br />
	학년 : ${ studentInfo.gradeNum } <br />
	반 : ${ studentInfo.classNum } 
</body>
</html>

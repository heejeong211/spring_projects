<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Home</title>
	</head>
	<body>
		<h1>
			Hello world!  
		</h1>

		<P>  The time on the server is ${serverTime}. </P> <!-- 이렇게 ${serverTime} 바로 집어넣으면 됨. -->
	</body>
</html>

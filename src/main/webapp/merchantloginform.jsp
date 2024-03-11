<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>


<body>

<h1 style=color:red>${message }</h1>

<form action="loginvalidation" method="post">

enter email:<input type="email" name="email" > <br>
enter password:<input type="password" name="password"> <br>
<input type="submit" value="login">

</form>

</body>
</html>
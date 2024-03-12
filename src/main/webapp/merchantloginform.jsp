<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
*{
    margin: 0;
    padding: 0;
    font-family: sans-serif;
}
body {
    width: 100%;
    height: 100vh;
    background: linear-gradient(45deg, #ffe5ae, #e823b5);
    position: relative;
}





</style>
<body>

<h1 style=color:red>${message }</h1>

<form action="loginvalidation" method="post">

enter email:<input type="email" name="email" > <br>
enter password:<input type="password" name="password"> <br>
<input type="submit" value="login">

</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD MERCHANT</title>
</head>

<body>
<div id="form-box">
	<form:form action="savemerchant" modelAttribute="merchantobj" class="input-group" id="Register">
		enter name:<form:input path="name"/> 	
		enter mobilenumber:<form:input path="mobilenumber"/>
		enter email:<form:input path="email"/> 
		enter password:<form:input path="password"/> 
		<input type="submit">
	</form:form>
	
</div>

</body>
</html>
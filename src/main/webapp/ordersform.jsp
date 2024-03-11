<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="saveorder" modelAttribute="ordersobj">
enter name:<form:input path="name"/>
enter Address:<form:input path="address"/>
enter MobileNumber:<form:input path="mobilenumber"/>
<input type="submit">

</form:form>


</body>
</html>
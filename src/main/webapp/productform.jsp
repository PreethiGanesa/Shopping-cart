<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Form</title>
</head>
<body>

<form:form action="saveproduct" modelAttribute="productobj">
enter brand:<form:input path="brand"/> <br>
enter model:<form:input path="model"/> <br>
enter category:<form:input path="category"/> <br>
enter price:<form:input path="price"/> <br>
enter stock:<form:input path="stock"/> <br>
<input type="submit">
</form:form>

</body>
</html>
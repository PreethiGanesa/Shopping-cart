<%@page import="com.pree.shoppingcart.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Customer c=(Customer)session.getAttribute("customerinfo");
	if(c!=null) 
	{ %>

	<h1>${message }</h1>

	<h1> <a href="displayproducts">Display allproducts</a> </h1>

	<h1> <a href="readbrandfromcustomer.jsp">Display Product By Brand</a> </h1>
	
	<h1> <a href="readcategoryfromcustomer.jsp">Display Product By Category</a></h1>
	
    <% } 
	else { %>
	
	<h1><a href="customerloginform.jsp">Login First</a></h1>

<% } %>
</body>
</html>
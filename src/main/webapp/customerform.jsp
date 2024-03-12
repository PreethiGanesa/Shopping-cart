<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
.main{
    height: 100%;
    width: 100%;
    background: linear-gradient(45deg, #ffe5ae, #e823b5);
    position: absolute;
}
.form-box{
    width: 280px;
    height: 200px;
    position: relative;
    margin: 6% auto;
    background:transparent;
    padding: 5px;

}
.input-field{
    width: 100%;
    padding: 10px 0;
    margin: 5px 0;
    border-left: 0;
    border-top: 0;
    border-right: 0;
    border-bottom: 1px solid #999;
    outline: none;
    background: transparent;
}
.submit-btn{
    width: 85%;
    padding: 10px 30px;
    cursor: pointer;
    display: block;
    margin: auto;
    background: linear-gradient(to right,#ff105f,#ffad06);
    border: 0;
    outline: none;
    border-radius: 30px;
}
</style>

<body>
	<div id="main">
		<div class="form-box">
           <h1 align="center">Register </h1>
			<form:form action="savecustomer" modelAttribute="customerobj">
				<form:input type="text" class="input-field" placeholder="Name" path="name"/>
				<form:input type="text" class="input-field" placeholder="Address" path="address"/>
				<form:input type="number" class="input-field" placeholder="mobilenumber" path="mobilenumber"/>
				<form:input type="email" class="input-field" placeholder="EMail" path="email"/>
				<form:input type="password" class="input-field" placeholder="Password" path="password"/>
				<input type="submit" class="submit-btn" value="Register">
			</form:form>
		</div>
	</div>

</body>
</html>
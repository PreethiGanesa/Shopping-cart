<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Merchant</title>

</head>
<style>
*{
    padding: 0px;
    margin: 0px;
    font-family: sans-serif;
}

body {
    width: 100%;
    height: 100vh;
    background: linear-gradient(45deg, #ffe5ae, #e823b5);
    position: relative;
}
.box{
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50% , -50%);
    width: 400px;
    background-color: #fff;
    padding: 40px 20px;
    border-radius: 10px;
    box-shadow: 0px 5px 20px -5px #000;
    text-align: center;
}
.box form .links{
    font-size: 16px;
    margin: 15px 0px;
}
.submit-btn{
    width: 85%;
    padding: 10px 30px;
    cursor: pointer;
    display: block;
    margin: auto;
    background: linear-gradient(to right,green,yellow);
    border: 0;
    outline: none;
    border-radius: 30px;
}

</style>
<body>
<div class="box">
<form action="#">

        <h1 align="center">Merchant </h1> 
            
       <div class="links"><a href="addmerchant" class="submit-btn">Register</a></div>
       <h1>${message}</h1>	
       <div class="links"><a href="merchantloginform.jsp" class="submit-btn">Login</a></div>
</form>
</div>
</body>
</html>
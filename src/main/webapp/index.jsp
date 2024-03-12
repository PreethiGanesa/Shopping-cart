<html>
<style>
*{
    padding: 0px;
    margin: 0px;
    font-family: sans-serif;
}

body {
    width: 100%;
    height: 100vh;
    background: linear-gradient(45deg, #3a3c93, #e923b5);
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
    background: linear-gradient(to right,#ff105f,#ffad06);
    border: 0;
    outline: none;
    border-radius: 30px;
}

</style>
<body>
<div class="box">
        <form action="#">

            <h1 align="center" style="font-family: cursive;" > WELCOME TO SHOPPING CART</h1> <br>
                <div class="links"> <a href="menu.jsp" class="submit-btn"> Merchant Login</a></div>
                <div class="links"> <a href="customermenu.jsp" class="submit-btn"> Customer Login</a></div>

        </form>
    </div>
    

</body>

</html>

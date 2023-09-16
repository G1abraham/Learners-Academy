<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"><title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="CSS/style.css">

</head>
<body class="body" >

<div><h1 style= "text-align: center; font-family: cursive">Welcome to my Learner's Academy</h1>
</div>
<h4 style= "text-align: center;">Sign in page for admin team</h4>

<div>
<form action="LogInServlet" method= "post"  class="login-container login-container">
<div>
<label for="emailId" >Enter your email</label><br>
<input required type="email" id= "emailId" name="email">
</div>
<div>
<label for="password" >Enter your password</label><br>
<input required type="password" id= "password" name="password">
</div>
<div>

<button type="submit" >Log in</button>
</div>
<div style="margin-top: 20px">
Don't have an account?<a href="RegistrationPage.jsp"> Create new account</a>
</div>

</form>

</div>

</body>
</html>
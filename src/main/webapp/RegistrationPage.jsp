<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
    <link rel="stylesheet" type="text/css" href="CSS/style.css">
</head>
<body class="body">

<div>
    <h1 style="text-align: center; font-family: cursive">Welcome to my Learner's Academy</h1>
</div>
<h4 style="text-align: center;">Registration page for new users</h4>

<div>
    <form action="SignInServlet" method="post" class="login-container">
        <div>
            <label for="name">Enter your name</label><br>
            <input required type="text" id="name" name="username">
        </div>
        <div>
            <label for="email">Enter your email</label><br>
            <input required type="email" id="email" name="email">
        </div>
        <div>
            <label for="password">Enter your password</label><br>
            <input required type="password" id="password" name="password">
        </div>
        <div>
<button type="submit" style="background-color: green">Create new account</button>        </div>
        <div style="margin-top: 20px">
            Already have an account? <a href="LoginPage.jsp">Log in</a>
        </div>
    </form>
</div>

</body>
</html>
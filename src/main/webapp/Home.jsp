<%@page import="entities.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<%@include file="Bootstrap.jsp" %>
<%@include file="Navbar.jsp" %>

</head>
<body>
<h1 style= "font-family: papayrus; text-align:center">Welcome to Learner's academy</h1>
<% 
HttpSession session2 = request.getSession();

String user = (String)session2.getAttribute("username");
%>
<h3 style="text-align: center; font-family: monospace; margin-top: 50px;">Welcome <%=user %></h3>
</body>
</html>
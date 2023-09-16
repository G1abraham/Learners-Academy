<%@page import="entities.Faculty"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="connection.FactoryProvider"%>
<%@page import="entities.Students"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Faculty</title>
  <%@include file="Bootstrap.jsp" %>
<%@include file="Navbar.jsp" %>

</head>
<body>
<%Session s=FactoryProvider.getFactory().openSession();

Query query= s.createQuery("from Faculty");
List<Faculty> faculty= query.list();
s.close();
%>
<div class="container">
<table class="table table-hover table-bordered mx-auto" >
 <thead>
 <tr>
 <td>Faculty Name</td>
 <td> Subject</td>
 </tr>
 </thead>
 <tbody>
 <% for(Faculty faculties: faculty){
 %>  
<tr>
<td> <%= faculties.getFacultyName() %></td>
<td> <%=faculties.getSubject().getSubjectName() %></td>
<td><a href="DeleteFaculty?FacultyId=<%=faculties.getFacultyId() %>" >Delete</a></td>

 </tr>
 <%
 }
 
 %>
 </tbody>
 </table>
</div>

<div style= "text-align: center; margin-top: 40px;">
<a href="AddFaculty.jsp" style="font-family: cursive;" > Add new Faculty</a>
</div>
 
</body>
</html>
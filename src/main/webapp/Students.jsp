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
<title>Insert title here</title>
  <%@include file="Bootstrap.jsp" %>
<%@include file="Navbar.jsp" %>

</head>
<body>
<%Session s=FactoryProvider.getFactory().openSession();

Query query= s.createQuery("from Students");
List<Students> students= query.list();
s.close();
%>
<div class="container">
<table class="table table-hover table-bordered mx-auto" >
 <thead>
 <tr>
 <td>Student Name</td>
 <td> Subject</td>
 </tr>
 </thead>
 <tbody>
 <% for(Students student: students){
 %>  
<tr>
<td> <%= student.getStudentName() %></td>
<td> <%=student.getSubject().getSubjectName() %></td>
<td><a href="DeleteStudent?studentId=<%=student.getStudentId() %>" >Delete</a></td>

 </tr>
 <%
 }
 
 %>
 </tbody>
 </table>
</div>

<div style= "text-align: center; margin-top: 40px;">
<a href="AddStudent.jsp" style="font-family: cursive;" > Add new Student</a>
</div>
 
</body>
</html>
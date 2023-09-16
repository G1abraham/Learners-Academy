<%@page import="entities.Subjects"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="connection.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="Bootstrap.jsp" %>
<%@include file="Navbar.jsp" %>
<link rel="stylesheet" type="text/css" href="CSS/style.css">
</head>
<body>
<% 
Session s = FactoryProvider.getFactory().openSession();
Query q= s.createQuery("From Subjects");
List<Subjects> subject = q.list();
%>
<form action="AddClass" method="post" class="login-container">
  <div class="row mb-3">
    <div class="col-sm-2 text-center">
      <label for="ClassName" class="col-form-label">Class Name</label>
    </div>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="ClassName" name="ClassName">
    </div>
  </div>
  <div class="row mb-3">
    <div class="row mb-3">
        <label for="subject" class="col-sm-2 col-form-label">Subject</label>
        <div class="col-sm-10">
            <select class="form-select" id="subject" name="classSubject">
            <%for(Subjects subjects: subject)  {%>
                <option value="<%=subjects.getSubjectName()%>"><%=subjects.getSubjectName()%></option>
                <%} %>
            </select>
        </div>
    </div>
   
  </div>
  <div class="row">
    <div class="col-sm-12 text-center">
      <button type="submit" class="btn btn-success">Add Class</button>
    </div>
  </div>
</form>
</body>
</html>
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
<form action="AddSubject" method="post" class="login-container">
  <div class="row mb-3">
    <div class="col-sm-2 text-center">
      <label for="Subject" class="col-form-label">Name of the Subject</label>
    </div>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="Subject" name="Subject">
    </div>
  </div>
  <div class="row">
    <div class="col-sm-12 text-center">
      <button type="submit" class="btn btn-success">Add Subject</button>
    </div>
  </div>
</form>
</body>
</html>
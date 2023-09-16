<%@page import="entities.Students"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="entities.Subjects"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="connection.FactoryProvider"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Schedule</title>
    <%@include file="Bootstrap.jsp" %>
<%@include file="Navbar.jsp" %>
</head>
<body>
    
    
  <%
    // Create the Hibernate session
    Session hibernateSession = FactoryProvider.getFactory().openSession();
    
    // Query for subjects
    Query<Subjects> query = hibernateSession.createQuery("from Subjects", Subjects.class);
    List<Subjects> subjectsList = query.list();
    %>
    
    <table class="table table-hover table-bordered">
        <thead>
            <tr>
                <th scope="col">Subject</th>
                <th scope="col">Class Name</th>
                <th scope="col">Faculty</th>
                <th scope="col">Students</th>
                <th scope="col"></th>
                <th scope="col"></th>
            </tr>
        </thead>
        <tbody>
            <%
            for (Subjects subject : subjectsList) {
                %>
                <tr>
                    <td><%= subject.getSubjectName() %>
                                        <input type="hidden" value= "<%=subject.getSubjectId()%>" name ="subjectId">               
                    </td>
                     <td><%= subject.getClassroom() != null ? subject.getClassroom().getClassName() : "N/A" %></td>
                    <td><%= subject.getFaculty() != null ? subject.getFaculty().getFacultyName() : "N/A" %></td>
                    <td>
                        <%
                        for (Students student : subject.getStudentsList()) {
                            out.print(student.getStudentName() + "<br>");
                        }
                        %>
                    </td>
                    
                </tr>
                <%
            }
            %>
        </tbody>
    </table>
    
    <%
    // Close the Hibernate session after using it
    hibernateSession.close();
    %>
</body>
</html>
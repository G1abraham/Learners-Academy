package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import connection.FactoryProvider;
import entities.Faculty;
import entities.Subjects;

/**
 * Servlet implementation class AddFaculty
 */
public class AddFaculty extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFaculty() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Fetching data from the Faculty JSP form
        String teacherName = request.getParameter("TeacherName");
        String teacherSubject = request.getParameter("FacultySubject");

        // Creating a Hibernate session and transaction
        Session s = FactoryProvider.getFactory().openSession();
        Transaction transaction = s.beginTransaction();

        try {
            // Check if the subject already exists in the database
            Subjects subject = (Subjects) s.createQuery("FROM Subjects WHERE subjectName = :name")
                    .setParameter("name", teacherSubject)
                    .uniqueResult();

            if (subject == null) {
                // If the subject doesn't exist, create a new one
                subject = new Subjects(teacherSubject);
                s.save(subject);
            }

            // Create the Faculty instance and associate it with the subject
            Faculty faculty = new Faculty();
            faculty.setFacultyName(teacherName);
            faculty.setSubject(subject);

            // Save the Faculty object into the database
            s.save(faculty);
            transaction.commit();

            // Redirect to a success page
            response.sendRedirect("Success.jsp");
        } catch (Exception e) {
            // If an exception occurs, rollback the transaction and redirect to a fail page
            transaction.rollback();
            response.sendRedirect("Fail.jsp");
        } finally {
            // Close the Hibernate session
            s.close();
        }
    }
}
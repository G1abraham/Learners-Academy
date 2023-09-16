package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import connection.FactoryProvider;
import entities.Students;
import entities.Subjects;

/**
 * Servlet implementation class AddStudent
 */
public class AddStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
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
        // Fetching data from the AddStudent jsp
        String studentName = request.getParameter("studentName");
        String studentSubject = request.getParameter("studentSubject");

        // Creating a factory session
        Session s = FactoryProvider.getFactory().openSession();
        Transaction transaction = s.beginTransaction();

        try {
            // Check if the subject already exists in the database
            Subjects subject = (Subjects) s.createQuery("FROM Subjects WHERE subjectName = :name")
                    .setParameter("name", studentSubject)
                    .uniqueResult();

            if (subject == null) {
                // If the subject doesn't exist, create a new one
                subject = new Subjects(studentSubject);
                s.save(subject);
            }

            // Create the student instance and associate it with the subject
            Students student = new Students(studentName, subject);

            // Save the student object into the database
            s.save(student);
            transaction.commit();

            // Redirect to a success page
            response.sendRedirect("Students.jsp");
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
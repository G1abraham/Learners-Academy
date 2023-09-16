package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import connection.FactoryProvider;
import entities.Subjects;

/**
 * Servlet implementation class AddSubject
 */
public class AddSubject extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSubject() {
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
        // Fetching data from the AddSubject JSP form
        String subjectName = request.getParameter("Subject");

        // Creating a Hibernate session and transaction
        Session session = FactoryProvider.getFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            // Check if the subject already exists in the database
            Subjects existingSubject = (Subjects) session.createQuery("FROM Subjects WHERE subjectName = :name")
                    .setParameter("name", subjectName)
                    .uniqueResult();

            if (existingSubject == null) {
                // If the subject doesn't exist, create a new one
                Subjects newSubject = new Subjects(subjectName);
                session.save(newSubject);
                transaction.commit();

                // Log success and redirect to a success page
                System.out.println("Subject added: " + subjectName);
                response.sendRedirect("Success.jsp");
            } else {
                // Log subject already exists and display a message
                System.out.println("Subject already exists: " + subjectName);
                PrintWriter out = response.getWriter();
                out.println("<p>Subject already exists</p>");
            }
        } catch (Exception e) {
            // Log the caught exception
            System.out.println("Exception caught: " + e.getMessage());
            e.printStackTrace();  // This will print the full stack trace of the exception

            // Rollback the transaction
            transaction.rollback();

            // Redirect to the Fail.jsp page
            response.sendRedirect("Fail.jsp");}
        finally {
            session.close();
        }
    }
}
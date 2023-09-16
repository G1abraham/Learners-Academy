package delete;

import java.io.IOException; 
import connection.FactoryProvider;
import entities.Students;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * Servlet implementation class DeleteStudent
 */
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long studentId = Long.parseLong(request.getParameter("studentId"));
		
		Session session= FactoryProvider.getFactory().openSession();
		
		Students student =(Students)session.get(Students.class, studentId);
		Transaction tx= session.beginTransaction();
	
		session.delete(student);
		tx.commit();
		session.close();
		
		response.sendRedirect("Students.jsp");
	
		
	}
	 
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
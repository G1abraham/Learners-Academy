package delete;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import connection.FactoryProvider;
import entities.Faculty;

/**
 * Servlet implementation class DeleteFaculty
 */
public class DeleteFaculty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFaculty() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Integer facultyId = Integer.parseInt(request.getParameter("FacultyId"));
			
			Session session= FactoryProvider.getFactory().openSession();
			
			Faculty faculty  =(Faculty)session.get(Faculty.class, facultyId);
			faculty.setSubject(null);
			Transaction tx= session.beginTransaction();
		
			session.delete(faculty);
			tx.commit();
			session.close();
			
			response.sendRedirect("Faculty.jsp");
		
			
		}
		 
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
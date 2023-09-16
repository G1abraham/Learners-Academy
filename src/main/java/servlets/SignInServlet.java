package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.mindrot.jbcrypt.BCrypt;

import connection.FactoryProvider;
import entities.Admin;

/**
 * Servlet implementation class SignInServlets
 */
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String username = request.getParameter("username");
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    //Hashing the password
	    String hashedpassword= BCrypt.hashpw(password, BCrypt.gensalt());
	 
	    
	    Session session = FactoryProvider.getFactory().openSession();
	    Transaction transaction = session.beginTransaction();
	    try {
	        Admin admin = new Admin(username, email, hashedpassword);
	        session.save(admin);
	        transaction.commit();
	        
	        PrintWriter out = response.getWriter();
	        out.println("<p>Registration successful! ID created.</p>");
	    } catch (Exception e) {
	        transaction.rollback();
	        
	        PrintWriter out = response.getWriter();
	        out.println("<p>Failed to register user.</p>");
	    } finally {
	        session.close();
	    }
	    HttpSession httpsession= request.getSession();
	    httpsession.setAttribute("username", username);
	    response.sendRedirect("Home.jsp");
	}


}
package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;

import connection.FactoryProvider;
import entities.Admin;

/**
 * Servlet implementation class LogInServlet
 */
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
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
		String email = request.getParameter("email");
		String enteredpassword= request.getParameter("password");
		
		Session s = FactoryProvider.getFactory().openSession();
		String hql = "FROM Admin WHERE emailID = :x";	
		
		Admin admin = (Admin) s.createQuery(hql)
			    .setParameter("x", email)
			    .uniqueResult();
		
		if(admin !=null && BCrypt.checkpw(enteredpassword, admin.getPassword())) {
			HttpSession session = request.getSession();
			session.setAttribute("username", admin.getUserName());
			response.sendRedirect("Home.jsp");
		}else {
			PrintWriter pw= response.getWriter();
			pw.print("Entered password or email is incorrect");
		}

			
		}
	}



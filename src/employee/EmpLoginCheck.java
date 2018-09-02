package employee;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.AdminBean;
import admin.AdminDao;

/**
 * Servlet implementation class EmpLoginCheck
 */
@WebServlet("/EmpLoginCheck")
public class EmpLoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpLoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("http://127.0.0.1:8080/HRMSWAR/Admin_Login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String password=request.getParameter("pass");
		int userid=Integer.parseInt(id);
		String errmsg=null;
		EmpBean emp=null;
		EmpDao dao=new EmpDao();
		try {
			emp=dao.findemp(userid);
			} catch (SQLException e) {
			errmsg="<h3>ERROR Occured in SQL operation "+e.getMessage()+" </h3>";
			request.setAttribute("ERRMSG", errmsg);
			
		}
		if(emp==null)
		{
			response.sendRedirect("http://127.0.0.1:8080/HRMSWAR/Emp_Login.jsp");
		}
		if(emp.getEmpid()==userid && emp.getPassword().equals(password))
		{
			HttpSession session=request.getSession(true);
			session.setAttribute("emp",emp);
			RequestDispatcher rd=request.getRequestDispatcher("EmpHome.jsp");
			rd.forward(request,response);
		}
		else
		{
			response.sendRedirect("http://127.0.0.1:8080/HRMSWAR/Emp_Login.jsp");
		}
	}
}



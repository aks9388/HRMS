package employee;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.AdminDao;

/**
 * Servlet implementation class ChangeEmpPass
 */
@WebServlet("/ChangeEmpPass")
public class ChangeEmpPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeEmpPass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("empid");
		String currentpass=request.getParameter("currentpass");
		String pass=request.getParameter("pass");
		String newpass=request.getParameter("newpass");
		int empid=Integer.parseInt(id);
		EmpDao dao=new EmpDao();
		if(pass.equals(currentpass))
		{
			try {
				dao.updatepass(empid, newpass);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher rd=request.getRequestDispatcher("Emp_Login.jsp");
			rd.forward(request,response);
		}
	}

}

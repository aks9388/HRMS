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
 * Servlet implementation class EditEmp
 */
@WebServlet("/EditEmp2")
public class EditEmp2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmp2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("empid");
		String empname=request.getParameter("empname");
		String empdept=request.getParameter("empdept");
		String address=request.getParameter("address");
		String mobile=request.getParameter("mobile");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		int empid=Integer.parseInt(id);
		EmpDao dao=new EmpDao();
		int returnvalue=0;
		
		try {
			returnvalue=dao.updateemp(empid,empname,empdept,address,mobile,email,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		if(returnvalue==1)
		{
			HttpSession session1 = request.getSession(false);
			if(session1 != null){
	            session1.invalidate();
	        }
	        HttpSession session = request.getSession(true);
	        EmpBean emp=null;
			EmpDao dao1=new EmpDao();
			try {
				emp=dao1.findemp(empid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("emp",emp);
			RequestDispatcher rd=request.getRequestDispatcher("EmpHome.jsp");
			rd.forward(request,response);
		}
		
	}

}

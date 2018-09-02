package employee;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import department.DepartmentDao;

/**
 * Servlet implementation class EditEmp
 */
@WebServlet("/EditEmp")
public class EditEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmp() {
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
			request.setAttribute("id", id);
			RequestDispatcher rd=request.getRequestDispatcher("/DisplayAllEmp");
			rd.forward(request,response);
		}
		
	}

}

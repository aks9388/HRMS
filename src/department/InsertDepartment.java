package department;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertDepartment
 */
@WebServlet("/InsertDepartment")
public class InsertDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDepartment() {
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
	
		String id=request.getParameter("deptid");
		String deptname=request.getParameter("deptname");
		String deptloc=request.getParameter("deptloc");
		String contact=request.getParameter("contact");
	//	int deptid=Integer.parseInt(id);
		DepartmentDao dao=new DepartmentDao();
	//	DepartmentBean dept=new DepartmentBean(deptid,deptname,deptloc,contact);
		try {
			dao.insertdept(deptname,deptloc,contact);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("/DisplayAllDept");
		rd.forward(request,response);
	}

}

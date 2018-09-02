package department;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayAllDept
 */
@WebServlet("/DisplayAllDept")
public class DisplayAllDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllDept() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepartmentDao dao=new DepartmentDao();
		ArrayList<DepartmentBean> array=new ArrayList<DepartmentBean>();
		try {
			array=dao.displayDepartment();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("array",array);
		RequestDispatcher rd=request.getRequestDispatcher("/DisplayAllDept.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepartmentDao dao=new DepartmentDao();
		ArrayList<DepartmentBean> array=new ArrayList<DepartmentBean>();
		try {
			array=dao.displayDepartment();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("array",array);
		RequestDispatcher rd=request.getRequestDispatcher("/DisplayAllDept.jsp");
		rd.forward(request,response);
	}

}

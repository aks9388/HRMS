package employee;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import department.DepartmentBean;
import department.DepartmentDao;

/**
 * Servlet implementation class DisplayAllEmp
 */
@WebServlet("/DisplayAllEmp")
public class DisplayAllEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllEmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDao dao=new EmpDao();
		ArrayList<EmpBean> array=new ArrayList<EmpBean>();
		try {
			array=dao.displayEmp();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("array",array);
		RequestDispatcher rd=request.getRequestDispatcher("/DisplayAllEmp.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDao dao=new EmpDao();
		ArrayList<EmpBean> array=new ArrayList<EmpBean>();
		try {
			array=dao.displayEmp();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("array",array);
		RequestDispatcher rd=request.getRequestDispatcher("/DisplayAllEmp.jsp");
		rd.forward(request,response);
	}

}

package employee;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

import leaverecord.*;

/**
 * Servlet implementation class InsertEmp
 */
@WebServlet("/InsertEmp")
public class InsertEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertEmp() {
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
		String empid=request.getParameter("empid");
		String empname=request.getParameter("empname");
		String empdept=request.getParameter("empdept");
		String address=request.getParameter("address");
		String mobile=request.getParameter("mobile");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		EmpDao dao= new EmpDao();
		LrecordDao dao1=new LrecordDao();
		int id=Integer.parseInt(empid);
		int cl=12;
		int pl=30;
		DateTime dt=new DateTime();
		String year="dt.getYear()";
		LrecordBean record=new LrecordBean(id,year,cl,pl);
		try {
			dao.insertemp(empname, empdept, address, mobile, email, password);
			dao1.insertlrecord(record);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("/DisplayAllEmp");
		rd.forward(request,response);
	}

}

package leaverqst;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LeaveRequest
 */
@WebServlet("/LeaveRequest")
public class LeaveRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveRequest() {
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
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String id=request.getParameter("empid");
		String name=request.getParameter("name");
		String dept=request.getParameter("dept");
		String type_of_leave=request.getParameter("type_of_leave");
		String datefrom=request.getParameter("datefrom");
		String dateto=request.getParameter("dateto");
		String totaldays=request.getParameter("totaldays");
		String reason=request.getParameter("reason");
		String status=request.getParameter("status");
		int empid=Integer.parseInt(id);
		int total_day=Integer.parseInt(totaldays);
		LrqstBean leave=new LrqstBean(empid,name,dept,type_of_leave,datefrom,dateto,total_day,reason,status);
		LrqstDao dao=new LrqstDao();
		int result=0;
		if(type_of_leave.equals("Casual Leave") && total_day>3) 
		{
			out.println("<html><body>");
			out.println("You are NOT ALLOTED more than 3 CL at a time");
			out.println("</body></html>");
		}
		else if(type_of_leave.equals("Privilaged Leave") && total_day<3) 
		{
			out.println("<html><body>");
			out.println("You MUST ASK for more than 3 PL at a time");
			out.println("</body></html>");
		}
		
		else
		{
		try {
			result=dao.insertlrqst(leave);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result==1)
		{
			request.setAttribute("empid", empid);
			RequestDispatcher rd=request.getRequestDispatcher("/ViewLeave2");
			rd.forward(request,response);
		}
	}

}
}

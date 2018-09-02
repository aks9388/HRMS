package attendance;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

/**
 * Servlet implementation class UpdateAttendance
 */
@WebServlet("/UpdateAttendance")
public class UpdateAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAttendance() {
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
		int empid=Integer.parseInt(id);
		DateTime dt=new DateTime();
		String date=dt.getDayOfMonth()+"-"+dt.getMonthOfYear()+"-"+dt.getYear();
		String timeout=dt.getHourOfDay()+":"+dt.getMinuteOfHour();
		int flag=0;
		AttendanceDao dao=new AttendanceDao();
		try {
			flag=dao.updateAttendance(empid, date, timeout);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag==1)
		{
			RequestDispatcher rd=request.getRequestDispatcher("EmpHome.jsp");
			rd.forward(request,response);
		}
	}

}

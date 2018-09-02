package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import department.DepartmentDao;
@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditProfile() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String userid=request.getParameter("id");
		String dob=request.getParameter("dob");
		String phone=request.getParameter("phone");
		int id=Integer.parseInt(userid);
		AdminDao dao=new AdminDao();
		int returnvalue=0;
		
		try {
			returnvalue=dao.updateadmin(id,dob, phone);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		if(returnvalue==1)
		{
			request.setAttribute("id", id);
			RequestDispatcher rd=request.getRequestDispatcher("/Profile");
			rd.forward(request,response);
		}
	}

}

package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminLoginCheck")
public class AdminLoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminLoginCheck() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("http://127.0.0.1:8080/HRMSWAR/Admin_Login.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String password=request.getParameter("pass");
		int userid=Integer.parseInt(id);
		String errmsg=null;
		AdminBean admin=null;
		AdminDao dao=new AdminDao();
		try {
			admin=dao.checkAdmin(userid);
		} catch (SQLException e) {
			errmsg="<h3>ERROR Occured in SQL operation "+e.getMessage()+" </h3>";
			request.setAttribute("ERRMSG", errmsg);
			
		}
		if(admin==null)
		{
			response.sendRedirect("http://127.0.0.1:8080/HRMSWAR/Admin_Login.jsp");
		}
		if(admin.getId()==userid && admin.getPassword().equals(password))
		{
			HttpSession session=request.getSession(true);
			session.setAttribute("admin",admin);
			RequestDispatcher rd=request.getRequestDispatcher("AdminHome.jsp");
			rd.forward(request,response);
		}
		else
		{
			response.sendRedirect("http://127.0.0.1:8080/HRMSWAR/Admin_Login.jsp");
		}
	}
}

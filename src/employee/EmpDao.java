package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import admin.AdminBean;
import department.DepartmentBean;

public class EmpDao {
	private Connection conn;
	private PreparedStatement insertpsmt;
	private PreparedStatement findempidpsmt;
	private PreparedStatement displaypsmt;
	private PreparedStatement showempidpsmt;
	private PreparedStatement findemppsmt;
	private PreparedStatement updatepsmt;
	private PreparedStatement updatepasspsmt;
	private ResultSet rs;
	String insertsql="insert into employee(empname,empdept,address,mobile,email,password) values(?,?,?,?,?,?)";
	String displaysql="select * from employee";
	String showempid="select empid from employee";
	String findsql="select * from employee where empid=?";
	String updatesql="update employee set empname=?,empdept=?,address=?,mobile=?,email=?,password=? where empid=?";
	String findempidsql="select empid from employee";
	String updatepasssql="update employee set password=? where empid=?";
	public EmpDao()
	{
		String url="jdbc:mysql://localhost:3306/hrms";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn=DriverManager.getConnection(url,"root","abhi");
			insertpsmt=conn.prepareStatement(insertsql);
			this.displaypsmt=conn.prepareStatement(displaysql);
			this.showempidpsmt=conn.prepareStatement(showempid);
			this.findemppsmt=conn.prepareStatement(findsql);
			this.updatepsmt=conn.prepareStatement(updatesql);
			this.findempidpsmt=conn.prepareStatement(findempidsql);
			this.updatepasspsmt=conn.prepareStatement(updatepasssql);
			} catch (SQLException e) {
			e.printStackTrace();
		}//end of constructor
	}
	public void insertemp(String empname, String empdept, String address,String mobile, String email, String password) throws SQLException
	{

		insertpsmt.setString(1,empname);
		insertpsmt.setString(2, empdept);
		insertpsmt.setString(3, address);
		insertpsmt.setString(4, mobile);
		insertpsmt.setString(5, email);
		insertpsmt.setString(6, password);
		this.insertpsmt.executeUpdate();
	}
	public int getempid() throws SQLException
	{
		rs=this.findempidpsmt.executeQuery();
		int empid=2000;
		if(rs==null)
		{
			return empid;
		}
		else
		{
			while(rs.next())
			{
				empid=rs.getInt(1);
			}
			return empid+1;
		}
	}
	public ArrayList<EmpBean> displayEmp() throws SQLException
	{
		rs=this.displaypsmt.executeQuery();
		ArrayList<EmpBean> array=new ArrayList<EmpBean>();
		EmpBean emp=null;
		while(rs.next())
		{
			int empid=rs.getInt(1);
			String empname=rs.getString(2);
			String empdept=rs.getString(3);
			String address=rs.getString(4);
			String mobile=rs.getString(5);
			String email=rs.getString(6);
			String password=rs.getString(7);
			emp=new EmpBean(empid,empname,empdept,address,mobile,email,password);
			array.add(emp);
			
		}
		return array;
	}
	public ArrayList<Integer> showempid() throws SQLException
	{
		rs=this.showempidpsmt.executeQuery();
		ArrayList<Integer> array=new ArrayList<Integer>();
		while(rs.next())
		{
			int empid=rs.getInt(1);
			array.add(empid);
			
		}
		return array;
	}
	public EmpBean findemp(int id) throws SQLException
	{
		this.findemppsmt.setInt(1, id);
		rs=this.findemppsmt.executeQuery();
		EmpBean emp=null;
		while(rs.next())
		{
		int empid=rs.getInt(1);
		String empname=rs.getString(2);
		String empdept=rs.getString(3);
		String address=rs.getString(4);
		String mobile=rs.getString(5);
		String email=rs.getString(6);
		String password=rs.getString(7);
		emp=new EmpBean(empid,empname,empdept,address,mobile,email,password);
		}
		return emp;
		
	}
	public int updateemp(int empid,String empname, String empdept, String address,String mobile, String email, String password) throws SQLException
	{	
		this.updatepsmt.setString(1,empname);
		this.updatepsmt.setString(2, empdept);
		this.updatepsmt.setString(3, address);
		this.updatepsmt.setString(4, mobile);
		this.updatepsmt.setString(5, email);
		this.updatepsmt.setString(6, password);
		this.updatepsmt.setInt(7,empid);
		int flag=this.updatepsmt.executeUpdate();
		return flag;
	}
	public int updatepass(int empid,String pass) throws SQLException
	{	
		this.updatepasspsmt.setString(1, pass);
		this.updatepasspsmt.setInt(2, empid);
		int flag=this.updatepasspsmt.executeUpdate();
		return flag;
	}
}

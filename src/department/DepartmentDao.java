package department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DepartmentDao {
	private Connection conn;
	private PreparedStatement finddeptpsmt;
	private PreparedStatement insertpsmt;
	private PreparedStatement updatepsmt;
	private PreparedStatement displaypsmt;
	private PreparedStatement finddeptidpsmt;
	private PreparedStatement showdeptnamepsmt;
	private ResultSet rs;
	
	String insertsql="insert into department(deptname,deptloc,contact) values(?,?,?)";
	String updatesql="update department set deptloc=?,contact=? where deptid=?";
	String findsql="select * from department where deptname=?";
	String displaysql="select * from department";
	String finddeptid="select deptid from department";
	String showdeptname="select distinct deptname from department";
	public DepartmentDao()
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
			this.finddeptpsmt=conn.prepareStatement(this.findsql);
			this.displaypsmt=conn.prepareStatement(displaysql);
			this.updatepsmt=conn.prepareStatement(updatesql);
			this.finddeptidpsmt=conn.prepareStatement(finddeptid);
			this.showdeptnamepsmt=conn.prepareStatement(showdeptname);
			} catch (SQLException e) {
			e.printStackTrace();
		}//end of constructor
	}
	public void insertdept(String deptname,String deptloc,String contact) throws SQLException
	{
		//insertpsmt.setInt(1, dept.getDeptid());
		insertpsmt.setString(1,deptname);
		insertpsmt.setString(2, deptloc);
		insertpsmt.setString(3,contact);
		this.insertpsmt.executeUpdate();
	}
	public ArrayList<DepartmentBean> finddept(String deptname) throws SQLException
	{
		this.finddeptpsmt.setString(1, deptname);
		rs=this.finddeptpsmt.executeQuery();
		ArrayList<DepartmentBean> array=new ArrayList<DepartmentBean>();
		DepartmentBean dept=null;
		while(rs.next())
		{
			int id=rs.getInt(1);
			String name=rs.getString(2);
			String loc=rs.getString(3);
			String cont=rs.getString(4);
			dept=new DepartmentBean(id,name,loc,cont);
			array.add(dept);			
		}
		return array;
	}
	public int getdeptid() throws SQLException
	{
		rs=this.finddeptidpsmt.executeQuery();
		int deptid=1000;
		if(rs==null)
		{
			return deptid;
		}
		else
		{
			while(rs.next())
			{
				deptid=rs.getInt(1);
			}
			return deptid+1;
		}
	}
	public ArrayList<DepartmentBean> displayDepartment() throws SQLException
	{
		rs=this.displaypsmt.executeQuery();
		ArrayList<DepartmentBean> array=new ArrayList<DepartmentBean>();
		DepartmentBean dept=null;
		while(rs.next())
		{
			int deptid=rs.getInt(1);
			String deptname=rs.getString(2);
			String deptloc=rs.getString(3);
			String contact=rs.getString(4);
			dept=new DepartmentBean(deptid,deptname,deptloc,contact);
			array.add(dept);
			
		}
		return array;
	}
	public ArrayList<String> showdeptname() throws SQLException
	{
		rs=this.showdeptnamepsmt.executeQuery();
		ArrayList<String> array=new ArrayList<String>();
		while(rs.next())
		{
			String deptname=rs.getString(1);
			array.add(deptname);
			
		}
		return array;
	}
	public int updatedept(int deptid,String deptloc,String contact) throws SQLException
	{	
		this.updatepsmt.setString(1,deptloc);
		this.updatepsmt.setString(2, contact);
		this.updatepsmt.setInt(3,deptid);
		int flag=this.updatepsmt.executeUpdate();
		return flag;
	}
	

}

package admin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import leaverecord.LrecordBean;


public class AdminDao {
	private Connection conn;
	private PreparedStatement findpsmt;
	private PreparedStatement displaypsmt;
	private PreparedStatement updatepsmt;
	private PreparedStatement updatepasspsmt;
	private ResultSet rs;
	
	String findsql="select * from admin where id=?";
	String updatepasssql="update admin set password=? where id=?";
	String updatesql="update admin set dob=?,phone=? where id=?";
	String displaysql="select * from admin";
	
	public AdminDao()
	{
		String url="jdbc:mysql://localhost:3306/hrms";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn=DriverManager.getConnection(url,"root","abhi");
			this.updatepasspsmt=conn.prepareStatement(updatepasssql);
			this.displaypsmt=conn.prepareStatement(displaysql);
			this.updatepsmt=conn.prepareStatement(updatesql);
			this.findpsmt=conn.prepareStatement(findsql);
			} catch (SQLException e) {
			e.printStackTrace();
		}//end of constructor	
	}
	public AdminBean checkAdmin(int userid) throws SQLException
	{
		this.findpsmt.setInt(1, userid);
		rs=this.findpsmt.executeQuery();
		AdminBean admin=null;
		while(rs.next())
		{
			int id=rs.getInt(1);
			String name=rs.getString(2);
			String dob=rs.getString(3);
			String phone=rs.getString(4);
			String password=rs.getString(5);
			admin=new AdminBean(id,name,dob,phone,password);
		}
		
		return admin;
	}
	public int updatepass(int empid,String pass) throws SQLException
	{	
		this.updatepasspsmt.setString(1, pass);
		this.updatepasspsmt.setInt(2, empid);
		int flag=this.updatepasspsmt.executeUpdate();
		return flag;
	}
	public int updateadmin(int empid,String dob,String phone) throws SQLException
	{	
		this.updatepsmt.setString(1, dob);
		this.updatepsmt.setString(2, phone);
		this.updatepsmt.setInt(3, empid);
		int flag=this.updatepsmt.executeUpdate();
		return flag;
	}
	public ArrayList<AdminBean> displaylrecord() throws SQLException
	{
		rs=this.displaypsmt.executeQuery();
		ArrayList<AdminBean> array=new ArrayList<AdminBean>();
		AdminBean record=null;
		while(rs.next())
		{
			int id=rs.getInt(1);
			String name=rs.getString(2);
			String dob=rs.getString(3);
			String phone=rs.getString(4);
			String password=rs.getString(5);
			record=new AdminBean(id,name,dob,phone,password);
			array.add(record);
			
		}
		return array;
	}
	
	
}

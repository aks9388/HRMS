package leaverqst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import department.DepartmentBean;

public class LrqstDao {
	private Connection conn;
	private PreparedStatement insertpsmt;
	private PreparedStatement displaypsmt;
	private PreparedStatement updatepsmt;
	private PreparedStatement showpsmt;
	private PreparedStatement showpsmt1;
	
	private ResultSet rs;
	
	String insertsql="insert into lrqst(empid,name,dept,type_of_leave,datefrom,dateto,total_day,reason,status) values(?,?,?,?,?,?,?,?,?) ";
	String updatesql="update lrqst set status=? where empid=? and datefrom=?";
	String displaysql="select * from lrqst";
	String showsql="select * from lrqst where status=?";
	String showsql1="select * from lrqst where empid=?";
	
	public LrqstDao()
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
			this.updatepsmt=conn.prepareStatement(updatesql);
			this.showpsmt=conn.prepareStatement(showsql);
			this.showpsmt1=conn.prepareStatement(showsql1);
			} catch (SQLException e) {
			e.printStackTrace();
		}//end of constructor
	}
	public int insertlrqst(LrqstBean record) throws SQLException
	{
		insertpsmt.setInt(1, record.getEmpid());
		insertpsmt.setString(2, record.getName());
		insertpsmt.setString(3,record.getDept());
		insertpsmt.setString(4,record.getType_of_leave());
		insertpsmt.setString(5,record.getDatefrom());
		insertpsmt.setString(6,record.getDateto());
		insertpsmt.setInt(7, record.getTotal_day());
		insertpsmt.setString(8,record.getReason());
		insertpsmt.setString(9,record.getStatus());
		
		int flag=insertpsmt.executeUpdate();
		return flag;
	}
	public ArrayList<LrqstBean> displaylrecord() throws SQLException
	{
		rs=this.displaypsmt.executeQuery();
		ArrayList<LrqstBean> array=new ArrayList<LrqstBean>();
		LrqstBean record=null;
		while(rs.next())
		{
			int empid=rs.getInt(1);
			String name=rs.getString(2);
			String dept=rs.getString(3);
			String type_of_leave=rs.getString(4);
			String datefrom=rs.getString(5);
			String dateto=rs.getString(6);
			int total_day=rs.getInt(7);
			String reason=rs.getString(8);
			String status=rs.getString(9);
			record=new LrqstBean(empid,name,dept,type_of_leave,datefrom,dateto,total_day,reason,status);
			array.add(record);
			
		}
		return array;
	}
	public int updatelrecord(int empid,String datefrom,String status ) throws SQLException
	{	
		this.updatepsmt.setString(1,status);
		this.updatepsmt.setInt(2,empid );
		this.updatepsmt.setString(3,datefrom );		
		int flag=this.updatepsmt.executeUpdate();
		return flag;
	}
	public ArrayList<LrqstBean> showdetail(String status) throws SQLException
	{
		this.showpsmt.setString(1, status);
		rs=this.showpsmt.executeQuery();
		ArrayList<LrqstBean> array=new ArrayList<LrqstBean>();
		LrqstBean record=null;
		while(rs.next())
		{
			int empid=rs.getInt(1);
			String name=rs.getString(2);
			String dept=rs.getString(3);
			String type_of_leave=rs.getString(4);
			String datefrom=rs.getString(5);
			String dateto=rs.getString(6);
			int total_day=rs.getInt(7);
			String reason=rs.getString(8);
			String stat=rs.getString(9);
			record=new LrqstBean(empid,name,dept,type_of_leave,datefrom,dateto,total_day,reason,stat);
			array.add(record);
			
		}
		return array;
	}
	public ArrayList<LrqstBean> show(int empid) throws SQLException
	{
		this.showpsmt1.setInt(1, empid);
		rs=this.showpsmt1.executeQuery();
		ArrayList<LrqstBean> array=new ArrayList<LrqstBean>();
		LrqstBean record=null;
		while(rs.next())
		{
			int empid1=rs.getInt(1);
			String name=rs.getString(2);
			String dept=rs.getString(3);
			String type_of_leave=rs.getString(4);
			String datefrom=rs.getString(5);
			String dateto=rs.getString(6);
			int total_day=rs.getInt(7);
			String reason=rs.getString(8);
			String stat=rs.getString(9);
			record=new LrqstBean(empid1,name,dept,type_of_leave,datefrom,dateto,total_day,reason,stat);
			array.add(record);
			
		}
		return array;
	}
}
package leaverecord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class LrecordDao {
	private Connection conn;
	private PreparedStatement insertpsmt;
	private PreparedStatement displaypsmt;
	private PreparedStatement updatepsmt;
	private ResultSet rs;
	
	String insertsql="insert into lrecord(empid,year,cl,pl) values(?,?,?,?) ";
	String updatesql="update lrecord set cl=?,pl=? where empid=? and year=?";
	String displaysql="select * from lrecord";
	
	public LrecordDao()
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
			} catch (SQLException e) {
			e.printStackTrace();
		}//end of constructor
	}
	public void insertlrecord(LrecordBean record) throws SQLException
	{
		insertpsmt.setInt(1, record.getEmpid());
		insertpsmt.setString(2, record.getYear());
		insertpsmt.setInt(3, record.getCl());
		insertpsmt.setInt(4, record.getPl());
		insertpsmt.executeUpdate();
	}
	public ArrayList<LrecordBean> displaylrecord() throws SQLException
	{
		rs=this.displaypsmt.executeQuery();
		ArrayList<LrecordBean> array=new ArrayList<LrecordBean>();
		LrecordBean record=null;
		while(rs.next())
		{
			int empid=rs.getInt(1);
			String year=rs.getString(2);
			int cl=rs.getInt(3);
			int pl=rs.getInt(4);
			record=new LrecordBean(empid,year,cl,pl);
			array.add(record);
			
		}
		return array;
	}
	public int updatelrecord(int empid,String year,int cl,int pl) throws SQLException
	{	
		this.updatepsmt.setInt(1,cl);
		this.updatepsmt.setInt(2,pl );
		this.updatepsmt.setInt(3,empid);
		this.updatepsmt.setString(4,year);
		int flag=this.updatepsmt.executeUpdate();
		return flag;
	}
}

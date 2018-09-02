package attendance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AttendanceDao {
	private Connection conn;
	private PreparedStatement insertpsmt;
	private PreparedStatement updatepsmt;
	private PreparedStatement displaypsmt;
	private ResultSet rs;
	
	String insertsql="insert into attendance(empid,date,timein,timeout) values(?,?,?,?)";
	String updatesql="update attendance set timeout=? where empid=? and date=?";
	String displaysql="select * from attendance";
	
	public AttendanceDao()
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
	public int insertAttendance(AttendanceBean attend) throws SQLException
	{
		insertpsmt.setInt(1,attend.getEmpid() );
		insertpsmt.setString(2,attend.getDate());
		insertpsmt.setString(3,attend.getTimein());
		insertpsmt.setString(4,attend.getTimeout());
		int flag=this.insertpsmt.executeUpdate();
		return flag;
		
	}
	public int updateAttendance(int empid,String date,String timeout) throws SQLException
	{
		this.updatepsmt.setString(1, timeout);
		this.updatepsmt.setInt(2, empid);
		this.updatepsmt.setString(3, date);
		
		int flag=this.updatepsmt.executeUpdate();
		return flag;
	}
	

}

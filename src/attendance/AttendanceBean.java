package attendance;

import java.util.Date;

import org.joda.time.DateTime;

public class AttendanceBean {
	private int empid;
	private String date;
	private String timein;
	private String timeout;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTimein() {
		return timein;
	}
	public void setTimein(String timein) {
		this.timein = timein;
	}
	public String getTimeout() {
		return timeout;
	}
	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}
	public AttendanceBean(int empid, String date, String timein, String timeout) {
		super();
		this.empid = empid;
		this.date = date;
		this.timein = timein;
		this.timeout = timeout;
	}
	
}

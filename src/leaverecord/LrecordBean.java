package leaverecord;

public class LrecordBean {
	private int empid;
	private String year;
	private int cl;
	private int pl;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getCl() {
		return cl;
	}
	public void setCl(int cl) {
		this.cl = cl;
	}
	public int getPl() {
		return pl;
	}
	public void setPl(int pl) {
		this.pl = pl;
	}
	public LrecordBean(int empid, String year, int cl, int pl) {
		super();
		this.empid = empid;
		this.year = year;
		this.cl = cl;
		this.pl = pl;
	}
	
}

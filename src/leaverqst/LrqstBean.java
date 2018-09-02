package leaverqst;

public class LrqstBean {
	private int empid;
	private String name;
	private String dept;
	private String type_of_leave;
	private String datefrom;
	private String dateto;
	private int total_day;
	private String reason;
	private String status;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getType_of_leave() {
		return type_of_leave;
	}
	public void setType_of_leave(String type_of_leave) {
		this.type_of_leave = type_of_leave;
	}
	public String getDatefrom() {
		return datefrom;
	}
	public void setDatefrom(String datefrom) {
		this.datefrom = datefrom;
	}
	public String getDateto() {
		return dateto;
	}
	public void setDateto(String dateto) {
		this.dateto = dateto;
	}
	public int getTotal_day() {
		return total_day;
	}
	public void setTotal_day(int total_day) {
		this.total_day = total_day;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LrqstBean(int empid, String name, String dept, String type_of_leave,
			String datefrom, String dateto, int total_day, String reason,
			String status) {
		super();
		this.empid = empid;
		this.name = name;
		this.dept = dept;
		this.type_of_leave = type_of_leave;
		this.datefrom = datefrom;
		this.dateto = dateto;
		this.total_day = total_day;
		this.reason = reason;
		this.status = status;
	}
	
}

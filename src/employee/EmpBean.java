package employee;

public class EmpBean {
	private int empid;
	private String empname;
	private String empdept;
	private String address;
	private String mobile;
	private String email;
	private String password;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmpdept() {
		return empdept;
	}
	public void setEmpdept(String empdept) {
		this.empdept = empdept;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public EmpBean(int empid, String empname, String empdept, String address,
			String mobile, String email, String password) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.empdept = empdept;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
	}
	

}

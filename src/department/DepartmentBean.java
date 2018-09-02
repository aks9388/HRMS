package department;

public class DepartmentBean {
	private int deptid;
	private String deptname,deptloc;
	private String conatct;
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptno(String deptname) {
		this.deptname = deptname;
	}
	public String getDeptloc() {
		return deptloc;
	}
	public void setDeptloc(String deptloc) {
		this.deptloc = deptloc;
	}
	public String getConatct() {
		return conatct;
	}
	public void setConatct(String conatct) {
		this.conatct = conatct;
	}
	public DepartmentBean(int deptid, String deptname, String deptloc, String conatct) {
		super();
		this.deptid = deptid;
		this.deptname = deptname;
		this.deptloc = deptloc;
		this.conatct = conatct;
	}

}

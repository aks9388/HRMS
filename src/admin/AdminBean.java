package admin;

public class AdminBean {
	private int id;
	private String name;
	private String dob;
	private String phone;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AdminBean(int id, String name, String dob, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.phone = phone;
		this.password = password;
	}
	
}

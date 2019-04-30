package timesheet;

public class User {
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getPersonal_emai() {
		return personal_emai;
	}
	public void setPersonal_emai(String personal_emai) {
		this.personal_emai = personal_emai;
	}
	public String getWork_email() {
		return work_email;
	}
	public void setWork_email(String work_email) {
		this.work_email = work_email;
	}
	public String getFiscal_code() {
		return fiscal_code;
	}
	public void setFiscal_code(String fiscal_code) {
		this.fiscal_code = fiscal_code;
	}
	public boolean isAdmin() {
		return Admin;
	}
	public void setAdmin(boolean admin) {
		Admin = admin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	private int id;
	private String first_name;
	private String last_name;
	private String personal_emai;
	private String work_email;
	private String fiscal_code;
	private boolean Admin;
	private String password;

}

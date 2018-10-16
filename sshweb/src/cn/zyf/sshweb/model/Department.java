package cn.zyf.sshweb.model;

public class Department {

	private int id;
	private String dptName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDptName() {
		return dptName;
	}
	public void setDptName(String dptName) {
		this.dptName = dptName;
	}
	public Department() {
		super();
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", dptName=" + dptName + "]";
	}
	
	
}

package cn.zyf.sshweb.model;

import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class User {

	private int id;
	
	@NotEmpty(message="用户名不能为空")
	private String username;
	
	@NotEmpty(message="密码不能为空")
	private String password;
	
	//使用 @JsonIgnoreProperties({"dpt"}) 标签可以不用关闭懒加载
	@NotNull
	private Department dpt;
	
	//使用注解 @DateTimeFormat(pattern="yyyy-MM-dd") Controller 可以不继承 BaseController
	//若使用自定义编译器不能用注解 @DateTimeFormat(pattern="yyyy-MM-dd")
	@Past
	private Date birthday;
	
	@DecimalMin(value="1.0")
	@DecimalMax(value="2.4")
	private Double height;
	
	@Email
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Department getDpt() {
		return dpt;
	}
	public void setDpt(Department dpt) {
		this.dpt = dpt;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", dpt=" + dpt + ", birthday="
				+ birthday + ", height=" + height + ", email=" + email + "]";
	}


}

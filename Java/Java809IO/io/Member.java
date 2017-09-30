package WORK.Java.Java809IO.io;

import java.io.Serializable;

public class Member implements Serializable{

	private String username;
	private transient String password;//transient阻止序列化
	private String sex;
	private String address;
	
	@Override
	public String toString() {
		return "Member [username=" + username + ", sex=" + sex + ", address=" + address + "]";
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}

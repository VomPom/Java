package WORK.Java.Java808Database.BALA.demo;

public class User {

	private int userid;
	private String name;
	private int password;
	private String address;
	private int phonenumber;
	private String birthday;
	private String sex;
	
	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", password=" + password + ", address=" + address
				+ ", phonenumber=" + phonenumber + ", birthday=" + birthday + ", sex=" + sex + "]";
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}

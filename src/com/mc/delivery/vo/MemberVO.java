package com.mc.delivery.vo;

public class MemberVO {
	private String userid;
	private String email;
	private String name;
	private String pwd;
	private String phone;
	private String brithday;
	private int admin;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBrithday() {
		return brithday;
	}
	public void setBrithday(String brithday) {
		this.brithday = brithday;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public MemberVO(String id, String email, String name, String password, String phone, String brithday, int admin) {
	
		this.userid = id;
		this.email = email;
		this.name = name;
		this.pwd = password;
		this.phone = phone;
		this.brithday = brithday;
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", email=" + email + ", name=" + name + ", pwd=" + pwd + ", phone="
				+ phone + ", brithday=" + brithday + ", admin=" + admin + "]";
	}
	public MemberVO(){}
	
	
	
}

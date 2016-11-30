package com.mc.delivery.vo;

public class MemberVO {
    private int point;
	private String email;
	private String name;
	private String pwd;
	private String phone;
	private String brithday;
	private int admin;
	
	
	
	
	
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
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
	public MemberVO(String email, String name, String password, String phone, String brithday, int admin) {
	
		
		this.email = email;
		this.name = name;
		this.pwd = password;
		this.phone = phone;
		this.brithday = brithday;
		this.admin = admin;
	}
	
	public MemberVO(int point, String email, String name, String pwd, String phone, String brithday, int admin) {
	
		this.point = point;
		this.email = email;
		this.name = name;
		this.pwd = pwd;
		this.phone = phone;
		this.brithday = brithday;
		this.admin = admin;
	}
	public MemberVO(){}
	@Override
	public String toString() {
		return "MemberVO [point=" + point + ", email=" + email + ", name=" + name + ", pwd=" + pwd + ", phone=" + phone
				+ ", brithday=" + brithday + ", admin=" + admin + "]";
	}
	
	
	
}

package com.zzti.share.dto;

public class UserInfo {

	private int id;
	private String username;
	private String phone;
	private String schoolName;
	private String professionName;
	private int gold;
	private int identity;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getProfessionName() {
		return professionName;
	}
	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public int getIdentity() {
		return identity;
	}
	public void setIdentity(int identity) {
		this.identity = identity;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", username=" + username + ", phone=" + phone + ", schoolName=" + schoolName
				+ ", professionName=" + professionName + ", gold=" + gold + ", identity=" + identity + "]";
	}
	
}

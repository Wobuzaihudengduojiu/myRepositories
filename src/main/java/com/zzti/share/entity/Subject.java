package com.zzti.share.entity;

public class Subject {
	private int id;
	private String subjectName;
	private int professionId;
	private int userId;
	private int ischeck;
	private int adminId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getProfessionId() {
		return professionId;
	}
	public void setProfessionId(int professionId) {
		this.professionId = professionId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getIscheck() {
		return ischeck;
	}
	public void setIscheck(int ischeck) {
		this.ischeck = ischeck;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	@Override
	public String toString() {
		return "Subject [id=" + id + ", subjectName=" + subjectName + ", professionId=" + professionId + ", userId="
				+ userId + ", ischeck=" + ischeck + ", adminId=" + adminId + "]";
	}
	
	
}

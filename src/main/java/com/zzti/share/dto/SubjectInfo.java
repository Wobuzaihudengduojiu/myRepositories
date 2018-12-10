package com.zzti.share.dto;

public class SubjectInfo {

	private int id;
	private String subjectName;
	private String professionName;
	private String username;
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
	public String getProfessionName() {
		return professionName;
	}
	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "SubjectInfo [id=" + id + ", subjectName=" + subjectName + ", professionName=" + professionName
				+ ", username=" + username + "]";
	}
	
}

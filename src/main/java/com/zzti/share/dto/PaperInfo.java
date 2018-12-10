package com.zzti.share.dto;

public class PaperInfo {

	private int id;
	private String tpName;
	private String subjectName;
	private String schoolName;
	private String username;
	private int score;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTpName() {
		return tpName;
	}
	public void setTpName(String tpName) {
		this.tpName = tpName;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "PaperInfo [id=" + id + ", tpName=" + tpName + ", subjectName=" + subjectName + ", schoolName="
				+ schoolName + ", username=" + username + ", score=" + score + "]";
	}
	
	
}

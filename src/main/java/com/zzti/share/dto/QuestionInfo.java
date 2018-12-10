package com.zzti.share.dto;

public class QuestionInfo {

	private int queId;
	private String value;
	private int lv;
	private String subjectName;
	private String knowledgeName;
	private String qtName;
	private String username;
	public int getQueId() {
		return queId;
	}
	public void setQueId(int queId) {
		this.queId = queId;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getLv() {
		return lv;
	}
	public void setLv(int lv) {
		this.lv = lv;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getKnowledgeName() {
		return knowledgeName;
	}
	public void setKnowledgeName(String knowledgeName) {
		this.knowledgeName = knowledgeName;
	}
	public String getQtName() {
		return qtName;
	}
	public void setQtName(String qtName) {
		this.qtName = qtName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "QuestionInfo [queId=" + queId + ", value=" + value + ", lv=" + lv + ", subjectName=" + subjectName
				+ ", knowledgeName=" + knowledgeName + ", qtName=" + qtName + ", username=" + username + "]";
	}
	
	
}

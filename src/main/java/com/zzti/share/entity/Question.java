package com.zzti.share.entity;

public class Question {
	private int id;
	private int queId;
	private String title;
	private String value;
	private int knowledgeId;
	private int typeId;
	private int subjectId;
	private int userId;
	private int lv;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	
	public int getKnowledgeId() {
		return knowledgeId;
	}
	public void setKnowledgeId(int knowledgeId) {
		this.knowledgeId = knowledgeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getLv() {
		return lv;
	}
	public void setLv(int lv) {
		this.lv = lv;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", queId=" + queId + ", title=" + title + ", value=" + value + ", knowledgeId="
				+ knowledgeId + ", typeId=" + typeId + ", subjectId=" + subjectId + ", userId=" + userId + ", lv=" + lv
				+ "]";
	}
	
	
}

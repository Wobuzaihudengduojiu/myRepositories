package com.zzti.share.entity;

import java.util.Date;

public class Tea_paper {
	private int id;
	private String tpName;
	private int subjectId;
	private int userId;
	private int schoolId;
	private String questionId;
	private String queScore;
	private int score;
	private Date openTime;
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
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Date getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}
	public String getQueScore() {
		return queScore;
	}
	public void setQueScore(String queScore) {
		this.queScore = queScore;
	}
	@Override
	public String toString() {
		return "Tea_paper [id=" + id + ", tpName=" + tpName + ", subjectId=" + subjectId + ", userId=" + userId
				+ ", schoolId=" + schoolId + ", questionId=" + questionId + ", queScore=" + queScore + ", score="
				+ score + ", openTime=" + openTime + "]";
	}
	
	
}

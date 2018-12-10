package com.zzti.share.entity;

public class Sub_check {
	private int id;
	private int userId;
	private int subjectId;
	private int ischeck;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public int getIscheck() {
		return ischeck;
	}
	public void setIscheck(int ischeck) {
		this.ischeck = ischeck;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Sub_check [id=" + id + ", userId=" + userId + ", subjectId=" + subjectId + ", ischeck=" + ischeck + "]";
	}
	
	
}

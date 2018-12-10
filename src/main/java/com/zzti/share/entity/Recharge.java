package com.zzti.share.entity;

import java.util.Date;

public class Recharge {
	private int id;
	private int userId;
	private int sum;
	private Date time;
	private int ischeck;
	private int adminId;
	private Date checkTime;
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
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
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
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	@Override
	public String toString() {
		return "Recharge [id=" + id + ", userId=" + userId + ", sum=" + sum + ", time=" + time + ", ischeck=" + ischeck
				+ ", adminId=" + adminId + ", checkTime=" + checkTime + "]";
	}
	
}
